package dz.djezzydevs.networkdep.business.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateOutputDto {

    private Long id;
    private String commune;
    private String name;

    private String adresse;
    private Float gpsX;
    private Float gpsY;
    private Boolean neralgique;
    private Boolean activeCandidate;

}
