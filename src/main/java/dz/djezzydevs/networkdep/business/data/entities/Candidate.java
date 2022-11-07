package dz.djezzydevs.networkdep.business.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String commune;
    private String name;

    private String adresse;
    private Float gpsX;
    private Float gpsY;
    private Boolean neralgique;
    private Boolean activeCandidate;


    @ManyToOne(fetch = FetchType.LAZY)
    private Site site;
}
