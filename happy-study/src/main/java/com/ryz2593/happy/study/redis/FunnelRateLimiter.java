package com.ryz2593.happy.study.redis;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 漏斗限流
 * 漏斗的剩余空间代表着当前行为可以持续进行的数量，
 * 漏嘴的流水速率代表着系统允许该行为的最大频率
 *
 * @author ryz2593
 */
public class FunnelRateLimiter {
    static class Funnel {
        //漏斗容量
        int capacity;
        //漏嘴流水速率
        float leakingRate;
        //漏斗剩余空间
        int leftQuota;
        //上一次漏水时间
        long leakingTs;

        public Funnel(int capacity, float leakingRate) {
            this.capacity = capacity;
            this.leakingRate = leakingRate;
            this.leftQuota = capacity;
            this.leakingTs = System.currentTimeMillis();
        }

        void makeSpace() {
            long nowTs = System.currentTimeMillis();
            //距离上一次漏水过去了多久
            long deltaTs = nowTs - leakingTs;
            //又可以腾出多少空间
            int deltaQuota = (int) (deltaTs * leakingRate);
            //时间间隔太长，整数数字过大溢出
            if (deltaQuota < 0) {
                this.leftQuota = capacity;
                this.leakingTs = nowTs;
                return;
            }
            //腾出空间太小，最小单位是1
            if (deltaQuota < 1) {
                System.out.println("腾出的空间太小");
                return;
            }
            //增加剩余空间
            this.leftQuota += deltaQuota;
            //记录漏水时间
            this.leakingTs = nowTs;
            //剩余空间不得高于容量
            if (this.leftQuota > this.capacity) {
                this.leftQuota = this.capacity;
            }
        }

        boolean watering(int quota) {
            makeSpace();
            //判断剩余空间是否足够
            if (this.leftQuota >= quota) {
                this.leftQuota -= quota;
                return true;
            }
            return false;
        }
    }

    private static Map<String, Funnel> funnels = Maps.newHashMap();
    public static boolean isActionAllowed(String userId, String actionKey, int capacity, float leakingRate) {
        String key =  String.format("%s:%s", userId, actionKey);
        Funnel funnel = funnels.get(key);
        if (funnel == null) {
            funnel = new Funnel(capacity, leakingRate);
            funnels.put(key, funnel);
        }
        //需要1个quota
        return funnel.watering(1);
    }


    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(isActionAllowed("ryz2593","login", 10,2.5f));
        }
    }
}
