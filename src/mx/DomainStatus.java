package mx;

public class DomainStatus {

    protected String url;
    protected Integer status;

    public DomainStatus(String url){
        this.url = url;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrl(){
        return url;
    }

    public Integer getStatus(){
        return status;
    }


}
