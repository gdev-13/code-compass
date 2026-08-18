package com.codecompass.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

	@NotBlank(message = "Nome é obrigatório")
	private String name;
	@Email(message = "E-mail inválido")
	@NotBlank(message = "E-mail é obrigatório")
	private String email;
	@NotBlank(message = "Senha é obrigatória")
	@Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
	private String password;
}
