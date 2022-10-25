package N3.Region.service.Impl;

import N3.Region.dto.PersonDto;
import N3.Region.dto.ResponseDto;
import N3.Region.entity.Person;
import N3.Region.repository.PersonRepository;
import N3.Region.service.PersonService;
import N3.Region.service.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public ResponseDto<String> addPerson(PersonDto personDto) {
        try{
            personRepository.save(personMapper.toEntity(personDto));
            return ResponseDto.<String>builder().code(0).success(true).message("Successfully create!").build();
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseDto.<String>builder().code(-1).success(false).message(e.getMessage()).build();
        }
    }

    @Override
    public ResponseDto deletePerson(Integer id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);

            return ResponseDto.builder()
                    .code(0)
                    .success(true)
                    .message("Successfully deleted!")
                    .build();
        }
        return ResponseDto.builder()
                .code(-1)
                .success(false)
                .message("Data not found!")
                .build();
    }

    @Override
    public ResponseDto<PersonDto> findById(Integer id){
        try{
            Optional<Person> personOptional = personRepository.findById(id);
            if (personOptional.isEmpty()){
                return ResponseDto.<PersonDto>builder()
                        .code(-1)
                        .success(false)
                        .message("Data not found").build();
            }

            Person person = personOptional.get();
            PersonDto personDto= personMapper.toDto(person);

            return ResponseDto.<PersonDto>builder().code(0).success(true).data(personDto).message("OK").build();
        }catch (Exception e){
            return ResponseDto.<PersonDto>builder().code(-1).success(false).message(e.getMessage()).build();
        }
    }
}
