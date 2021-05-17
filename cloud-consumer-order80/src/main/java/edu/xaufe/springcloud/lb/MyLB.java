package edu.xaufe.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/12/10:58
 * @Description:
 */
@Component
public class MyLB implements LoadBalancer{
    //在多线程下面建议不要用 n++类似的东西，建议使用原子整形类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获得为当前第几次请求的服务器实例的下标
     * @return
     */
    public final int getAndIncrement(){
        int current;
        int next;
        //自旋锁
        do{
            //获得当前主物理内存的值
            current = this.atomicInteger.get();
            //程序的严谨性
            next = current > Integer.MAX_VALUE ? 1 : current + 1;
            //当期望值与主物理内存的值相同时，代表没有被修改过，则就修改主物理内存的值，否则就自旋
        }while(!this.atomicInteger.compareAndSet(current,next));//第一个是期望值，第二个是修改值
        System.out.println("第几次访问请求,next:" + next);
        return next;
    }

    /**
     * 获得在所有服务机器里面来提供当前服务的服务机器实例
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {//传入可提供服务机器的列表
        int index = getAndIncrement() % serviceInstances.size();//获得提供服务的机器下标
        return serviceInstances.get(index);//返回提供服务的具体机器
    }
}
