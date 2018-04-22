package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.*;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)   
@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class InfoAnalysis {

    @Embedded
    @JsonIgnore
    @AttributeOverrides({  
            @AttributeOverride(name = "username", column = @Column(name = "username")),
            @AttributeOverride(name = "address", column = @Column(name = "address"))
    })
    private UserInfo userInfo;

    private String runningId;
    @JsonIgnore
    private double latitude;
    @JsonIgnore
    private double longitude;
    @JsonIgnore
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate = 60 + (int)(Math.random() * 141);

    @Id   
    @GeneratedValue    
    private Long userId;

    private String healthWarningLevel;

    @JsonIgnore
    private Date timestamp = new Date();

    public InfoAnalysis() {
        this.userInfo = null;
    }

    @JsonCreator
    public InfoAnalysis(@JsonProperty("runningId") String runningId,
                        @JsonProperty("totalRunningTime") double totalRunningTime,
                        @JsonProperty("heartRate") int heartRate,
                        @JsonProperty("userId") Long userId,
                        @JsonProperty("userInfo") UserInfo userInfo,
                        @JsonProperty("username") String username,
                        @JsonProperty("address") String address,
                        @JsonProperty("healthWarningLevel") String healthWarningLevel){

        this.runningId = runningId;
        this.totalRunningTime = totalRunningTime;
        this.heartRate = 60 + (int)(Math.random() * 141);
        this.userId = userId;
        this.userInfo = userInfo;
        this.userInfo.username = userInfo.username;
        this.userInfo.address = userInfo.address;
        this.healthWarningLevel = healthWarningLevel;
    }


    @JsonIgnore
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public String getUsername() { 
        return userInfo.username;
    }



    public String getAddress() {   
        return userInfo.address;
    }


    public String getHealthWarningLevel() {
        if (this.heartRate >= 60 && this.heartRate <= 75) {
            return "LOW";
        } else if (this.heartRate > 75 && this.heartRate <= 120) {
            return "NORMAL";
        } else if (this.heartRate > 120) {
            return "HIGH";
        }
        return "UNKNOWN";
    }


}