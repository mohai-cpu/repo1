//package cn.itcast.study.sftp.test;
//
//import cn.itcast.study.sftp.config.ConnectLinuxCommand;
//import cn.itcast.study.sftp.config.RemoteConnect;
//import org.junit.Test;
//
//import java.io.IOException;
//
//public class Ssh2Test {
//    //测试登录连接
//    @Test
//    public void testLogin() {
//        RemoteConnect remoteConnect = new RemoteConnect();
//        remoteConnect.setIp("212.64.44.141");
//        remoteConnect.setUserName("lbb");
//        remoteConnect.setPassword("lbb12345");
//        Boolean login = ConnectLinuxCommand.login(remoteConnect);
//        if(login){
//            System.out.println("登录连接成功");
//        }
//    }
//    //测试执行命令
//    @Test
//    public void testCmd() {
//        //cd /home/ubuntu/Desktop/music_rec/user_sim/result;cat xyy_result_m10d.json
//        //String commandStr="cd /home;rm -rf aa.txt";
//        //String commandStr="cd /home/lbb/Steam;cat ceshi01.txt;rm -rf ceshi01.txt";
//        String commandStr="cd /home/lbb/Steam; java -jar springboot01-0.0.1-SNAPSHOT.jar";
//        Boolean result= ConnectLinuxCommand.connectLinux("212.64.44.141","lbb","lbb12345",commandStr);
//        System.out.println(result);
//    }
//    //测试下载
//    @Test
//    public void testDownload() throws IOException {
//        try {
//            ConnectLinuxCommand.scpGet("212.64.44.141","lbb","lbb12345", "/home/lbb/Steam/ceshi01.txt", "d:/ceshi");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    //测试上传
//    @Test
//    public void testUpload() {
//        try {
//            ConnectLinuxCommand.scpPut("212.64.44.141","lbb","lbb12345", "D:/Users/springboot01-0.0.1-SNAPSHOT.jar", "/home/lbb/Steam");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
