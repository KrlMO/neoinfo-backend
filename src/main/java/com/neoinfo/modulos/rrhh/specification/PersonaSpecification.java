/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.modulos.rrhh.specification;

import com.neoinfo.modulos.rrhh.dto.PersonaFilterDTO;
import com.neoinfo.modulos.rrhh.entity.Persona;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author calmo
 */
public class PersonaSpecification {

    public static Specification<Persona> withFiler(PersonaFilterDTO filter) {
        return (root, query, cb) -> {
            var predicates = cb.conjunction();

            if (filter.getUsername() != null && !filter.getUsername().isEmpty()) {
                var usuarioJoin = root.join("usuario"); // el campo que agregaste en Persona
                predicates.getExpressions().add(
                        cb.like(cb.lower(usuarioJoin.get("username")), "%" + filter.getUsername().toLowerCase() + "%")
                );
            }

            if (filter.getName() != null && !filter.getName().isEmpty()) {
                predicates.getExpressions().add(
                        cb.like(cb.lower(root.get("nombres")), "%" + filter.getName().toLowerCase() + "%")
                );
            }

            
            if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
                predicates.getExpressions().add(
                        cb.like(cb.lower(root.get("email")), "%" + filter.getEmail().toLowerCase() + "%")
                );
            }


            if (filter.getDni() != null && !filter.getDni().isEmpty()) {
                predicates.getExpressions().add(cb.equal(root.get("dni"), filter.getDni()));
            }


            if (filter.getIdRole() > 0) {
                var usuarioJoin = root.join("usuario");
                var rolesJoin = usuarioJoin.join("roles");
                predicates.getExpressions().add(cb.equal(rolesJoin.get("id"), filter.getIdRole()));
            }

            if (filter.getRegisterDateFrom() != null) {
                var usuarioJoin = root.join("usuario");
                predicates.getExpressions().add(
                        cb.greaterThanOrEqualTo(usuarioJoin.get("fechaRegistro"), filter.getRegisterDateFrom())
                );
            }
            if (filter.getRegisterDateTo() != null) {
                var usuarioJoin = root.join("usuario");
                predicates.getExpressions().add(
                        cb.lessThanOrEqualTo(usuarioJoin.get("fechaRegistro"), filter.getRegisterDateTo())
                );
            }

            return predicates;
        };
    }
}
