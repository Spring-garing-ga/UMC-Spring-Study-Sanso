package umc.study.spring.convertor;

import umc.study.spring.domain.Address;
import umc.study.spring.domain.User;
import umc.study.spring.domain.enums.Gender;
import umc.study.spring.dto.AddressDTO;
import umc.study.spring.dto.UserRequestDTO;
import umc.study.spring.dto.UserResponseDTO;

import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDTO request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        AddressDTO addressDTO = new AddressDTO(request.getZip_code(),request.getAddress(),request.getDetail(),0);
        Address address = AddressConverter.toAddress(addressDTO);


        return User.builder()
                .address(address)
                .gender(gender)
                .name(request.getName())
                .birth(request.getBirth())
                .nickname(request.getNickname())
                .term(request.getTerm())
                .userPreferList(new ArrayList<>())
                .build();
    }
}
