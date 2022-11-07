package dz.djezzydevs.networkdep.business.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiteInputDto {

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


    /*
    ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(userRequest, UserDto.class);


        UserDto createUser = userService.createUser(userDto);

        UserResponse userResponse = modelMapper.map(createUser, UserResponse.class);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);

    */

}
