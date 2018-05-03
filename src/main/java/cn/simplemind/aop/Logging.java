package cn.simplemind.aop;

/**
 * 
 * @author yingdui_wu
 * @date 2018年5月3日 上午8:46:44
 */
public class Logging {
    public void beforeAdvice() {
        System.out.println("Going to setup student profile.");
    }

    public void afterAdvice() {
        System.out.println("Student profile has been setup.");
    }

    public void afterReturningAdvice(Object retVal) {
        System.out.println("Returning:" + retVal.toString());
    }

    public void AfterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("There has been an exception: " + ex.toString());
    }
}
