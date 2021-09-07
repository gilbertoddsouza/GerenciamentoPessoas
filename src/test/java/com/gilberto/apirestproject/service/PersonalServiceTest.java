package com.gilberto.apirestproject.service;

import com.gilberto.apirestproject.dto.request.PersonDTO;
import com.gilberto.apirestproject.dto.response.MessageResponseDTO;
import com.gilberto.apirestproject.entity.Person;
import com.gilberto.apirestproject.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.gilberto.apirestproject.utils.PersonUtils.createFakeDTO;
import static com.gilberto.apirestproject.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonalServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testeGivenPersonDTOThenRetundSendMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavdPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavdPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavdPerson.getId());
        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}