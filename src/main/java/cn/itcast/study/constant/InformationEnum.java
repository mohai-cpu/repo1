package cn.itcast.study.constant;

public enum InformationEnum {
    FOUCS_NEWS("1005","今日头条"),INSURE_NEWS("1113","保险聚焦");
    private String code;
    private String msg;
    private InformationEnum(String code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
