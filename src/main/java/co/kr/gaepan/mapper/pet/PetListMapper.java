package co.kr.gaepan.mapper.pet;


import co.kr.gaepan.dto.pet.PetCateDTO;
import co.kr.gaepan.dto.pet.PetRegisterDTO;
import co.kr.gaepan.dto.pet.PetTypeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
@Mapper
public interface PetListMapper {

    public List<PetRegisterDTO> petlist();
    public List<PetRegisterDTO> petdoglist(String cate);
    public List<PetRegisterDTO> petcatlist(String cate);
    public List<PetRegisterDTO> petetclist(String cate);
    public PetRegisterDTO pet(String no);
    public List<PetCateDTO> petcategory();
    public List<PetTypeDTO> petType(int cate);

}
