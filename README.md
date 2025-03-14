#  Generador de Contraseñas Cliente-Servidor

He creado este proyectito para poner en práctica la comunicación entre un Cliente y un Servidor con Java.
Para darle una funcionalidad, lo hice "Genereador de contraseñas", de forma que cuando un cliente se conecta al servidor, interaccionan para conseguir una contraseña.

## Tecnologías Utilizadas
Utilicé el lenguaje **Java**, basándome en la Programación Orientada a Objetos (POO). 
Además utilicé **Multihilos** usando `Thread` para gestionar concurrencia.
Sobre las **Redes**, implementé **Sockets en TCP/IP** 

## Roles del Cliente y del Servidor
1. **Servidor:**
   - Primero, le pregunta al cliente por su nombre
   - Luego, escucha peticiones del cliente
   - Recoge los criterios de la contraseña
   - Genera y envía la contraseña segura al cliente

3. **Cliente:**
   - Envia los criterios de la contraseña al servidor
   - Recibe y muestra la contraseña generada

## Funcionalidades
- Comunicación Cliente-Servidor a través de Sockets en Java
- Generación de contraseñas según requisitos del usuario
- Validación de datos básica en la comunicación
- Ejecución en paralelo de clientes gracias a hilos  

## Cómo Ejecutar el Proyecto
### 1. Clonar el Repositorio
```sh
 git clone https://github.com/TeacherCelia/cliente-servidor-java.git
 cd cliente-servidor-java
```

### 2. Compilar el Proyecto
Desde la carpeta del proyecto, compila ambas clases:
```sh
javac servidor/Servidor.java
javac cliente/Cliente.java
```

### 3. Ejecutar el Servidor
```sh
java servidor.Servidor
```

### 4. Ejecutar el Cliente
En otra terminal:
```sh
java cliente.Cliente
```

## Ejemplo de posible salida

### Terminal Cliente
```sh
Iniciando cliente...
Hola, soy un servidor. ¿Cómo te llamas?
Celia
Te doy la bienvenida Celia.
Voy a solicitarte distintos requisitos para la contraseña que voy a generar.
¿Cuántas minúsculas debe tener la contraseña?
2
¿Cuántas mayúsculas debe tener la contraseña?
3
¿Cuántos dígitos debe tener la contraseña?
2
¿Cuántos caracteres especiales debe tener la contraseña?
4
La longitud de la contraseña que se va a generar es de 11
¿Quieres generar la contraseña ahora? [si/no]
si
La contraseña generada es: _4X+(*fiCN2
```

### Terminal Servidor
```sh
Esperando al cliente...
Cliente conectado desde /127.0.0.1
Nombre del cliente: Celia
Los requisitos del cliente son los siguientes: 
PasswordReqs{minusculas=2, mayusculas=3, digitos=2, caracteresEspeciales=4}
Se ha enviado la longitud de la contraseña al cliente
Se ha enviado la contraseña al cliente.
Esperando al cliente...
```

## Mejoras Futuras
Conforme vaya teniendo tiempo, me gustaría mejorar el control de errores, crear algún método de cifrado de la contraseña antes de ser enviada al cliente, y crear una interfaz gráfica del proyecto.

