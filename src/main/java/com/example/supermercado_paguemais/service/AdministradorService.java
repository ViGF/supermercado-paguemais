    package com.example.supermercado_paguemais.service;
    
    import com.example.supermercado_paguemais.model.Administrador;
    import com.example.supermercado_paguemais.model.UsuarioRole;
    import com.example.supermercado_paguemais.repository.AdministradorRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;
    
    @Service
    public class AdministradorService {
    
        @Autowired
        private AdministradorRepository administradorRepository;
    
        @Autowired
        private PasswordEncoder passwordEncoder;

        @jakarta.annotation.PostConstruct
        public void criarPrimeiroAdmin() {
            if (administradorRepository.count() == 0) {
                Administrador admin = new Administrador();
                admin.setMatriculaFuncionario("4012536987");
                admin.setEmail("admin@supermercado.com");
                admin.setSenha(passwordEncoder.encode("admin123"));
                admin.setRole(UsuarioRole.ADMIN);
                admin.setMatriculaFuncionario("ADM-001");

                administradorRepository.save(admin);
                System.out.println(">>> ADMIN PADRÃO CRIADO COM SUCESSO: admin@supermercado.com / admin123");
            } else {
                System.out.println(">>> ADMIN já existe no banco, pulando criação.");
            }
        }
    }
