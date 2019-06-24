package patrick.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2000)
    private String request;

    @Column(length = 2000)
    private String response;

    private Date dtIncl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getDtIncl() {
        return dtIncl;
    }

    public void setDtIncl(Date dtIncl) {
        this.dtIncl = dtIncl;
    }
}
