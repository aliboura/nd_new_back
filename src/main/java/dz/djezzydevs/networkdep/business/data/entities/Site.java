package dz.djezzydevs.networkdep.business.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Site {




    @Id
//    @GeneratedValue
//    private Long id;

    private String code;
    private String region;
    private String wilaya;
    private String type;
    private String numero;
    private String nom;
    private String otasharing;
    private String celule;
    private String siteComment;
    private boolean importantSite;
    private boolean reminderAnf;


    private LocalDate dateDebut;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "site")
    private List<Candidate> condidates;

//    @OneToOne(fetch = FetchType.LAZY)
//    private Candidate activeCandidate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "site")
    private List<SiteComment> comments;

}
