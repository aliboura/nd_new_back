package dz.djezzydevs.networkdep.business.data.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SiteComment {
    @Id
    @GeneratedValue
    private Long id ;
    private String siteComment ;
    private Date commentDate;
    private String commentBy ;

    @ManyToOne
    Site site;

}
