/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.validation.api.builtin.stringvalidation;

import org.netbeans.validation.api.Problems;
import org.openide.util.NbBundle;

/**
 *
 * @author Annie Este validador comprueba que la primera letra sea mayúscula.
 */
public class MayusculaValidator extends StringValidator {

    /**
     * Este método valida si la primera letra del string es mayúscula
     *
     * @param problems lista de problemas. Si no añadimos ninguno, la validación
     * es correcta. Si añadimos un problema, el componente no validará y
     * mostrará el mensaje de error
     * @param compName Nombre del componente (lo que pongamos en name en las
     * propiedades del componente.
     * @param model texto actual del componente. Debemos realizar la validación
     * asegurándonos de que nuestro código no da ninguna excepción para todos
     * los casos.
     */
    @Override
    public void validate(Problems problems, String compName, String texto) {
        if (texto.isEmpty() || !Character.isUpperCase(texto.charAt(0))) {
            String msg = NbBundle.getMessage(this.getClass(), "MSG_MAYUSCULAS", compName);
            problems.add(msg);
        }
    }
}
