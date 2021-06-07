package cn.itcast.study.mythread.twochapter;

public class MyService5 {
    public MyOneList addServiceMethod(MyOneList list,String data){
        synchronized (list){
            try{
                if(list.getSize()<1){
                    Thread.sleep(2000);
                    list.add(data);//a //b
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return list;
        }
    }
}
