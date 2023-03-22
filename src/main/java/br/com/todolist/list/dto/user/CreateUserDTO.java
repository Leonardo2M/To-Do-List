package br.com.todolist.list.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {

    @NotBlank
    @Min(3)
    private String username;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Min(6)
    private String password;

}
