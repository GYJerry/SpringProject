package cn.simplemind.springCfgBaseJave;

/**
 * 
 * @author yingdui_wu
 * @date   2018年4月23日 上午10:43:38
 */
public class Grade {
    /**
     * @param name
     * @param no
     */
    public Grade(String name, Integer no) {
        super();
        this.name = name;
        No = no;
    }

    private String name;
    
    private Integer No;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNo() {
        return No;
    }

    public void setNo(Integer no) {
        No = no;
    }
}
