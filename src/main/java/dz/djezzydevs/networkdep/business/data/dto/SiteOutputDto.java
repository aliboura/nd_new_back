package dz.djezzydevs.networkdep.business.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiteOutputDto {

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
}
