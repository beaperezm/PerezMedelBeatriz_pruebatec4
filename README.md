# ASO

El objetivo principal de este proyecto es gestionar simulaciones de tarjetas de crédito para un cliente a través de un servicio que acepta peticiones POST con datos en formato JSON.

## Objetivos del proyecto

Se espera recibir un JSON con detalles específicos sobre la simulación de contratación.

El path es gestionado con un @PathParam:

```java

http://localhost:7500/TechArchitecture/helloWorld/v0/simulations/{nuip}

```

Se ha realizado el mapeo entre capas, realizando un flujo entre facade, business y dao.

### Pruebas realizadas

- Si se intenta poner minúsculas en: _details.offerType_ el status de la respuesta será **400 Bad Request**

![Minusculas](/imagenes%20aso/minusculas%20details.offerType.png)

- La cantidad máxima permitida no puede ser nula _details.limitAmount.amount_

![limitAmount](/imagenes%20aso/limitAmount%20null%20request.png)
![limitAmount R](/imagenes%20aso/limitAmount%20null%20response.png)

- La moneda _details.limitAmount.currency_ no puede ser nula ni vacía

![currency empty](/imagenes%20aso/currency%20vacia.png)
![currency null](/imagenes%20aso/currency%20null.png)

- El identificador de producto _details.product.id_ tiene que ser TDC, sino la respuesta será **400 Bad Request**

![tdc](/imagenes%20aso/TDC.png)

- El subproducto _details.product.subproduct.id_ solo puede contener de 0 a 2 caracteres

![tres](/imagenes%20aso/mas%20de%202%20caracteres.png)

![dos](/imagenes%20aso/2caracter.png)
![dos R](/imagenes%20aso/2caracterresponse.png)

![uno](/imagenes%20aso/1caracter.png)
![uno R](/imagenes%20aso/1caracterresponse.png)

![cero](/imagenes%20aso/0caracter.png)
![cero R](/imagenes%20aso/0caracterresponse.png)

✅ Campos que son el mismo en la entrada y en la respuesta del servicio:

> _offerType_

> _limitAmount.amount_

> _product.id_

> _product.subproduct.id_

✅ El campo de salida _data.id_ es aleatorio y se compone de 10 dígitos

```java

"id": "1450292687"

```

✅ El campo de salida _data.nuip_ es el mismo que el del @PathParam

```java
http://localhost:7500/TechArchitecture/helloWorld/v0/simulations/123456789

 "nuip": "123456789"

```

✅ El valor del campo de salida _data.details.minimumAmount.amount_ es un 10% menos que el valor del campo de entrada _details.limitAmount.amount_

✅ El valor del campo de salida _data.details.maximumAmount.amount_ es un 5% más que el valor del campo de entrada _details.limitAmount.amount_

✅ El campo de salida _data.details.maximumAmount.currency_ y _data.details.minimumAmount.currency_ es el mismo valor que el de la entrada _details.limitAmount.currency_

```java
"limitAmount": {
            "amount": 200000,
            "currency": "EUR"
}

 "minimumAmount": {
            "currency": "EUR",
            "amount": 180000
},
"maximumAmount": {
            "currency": "EUR",
            "amount": 210000
}

```

🔹 El resultado obtenido en Postman es este:

✔️ REQUEST:

![Request Postman](/imagenes%20aso/requestPostman.png)

✔️ RESPONSE:

![Response Postman](/imagenes%20aso/responsePostman.png)

🔹 Al considerarse mala práctica, en el código ningún import tiene \* ; ejemplos:

![dao](/imagenes%20aso/imports%20sin%20asterisco%20DAO.png)

![facade impl](/imagenes%20aso/imports%20sin%20asterisco.png)

---

# APX

Almacenar la información de un cliente en una base de datos Oracle mediante un proceso de inserción.

## Objetivos del proyecto

La salida esperada debe reflejar la misma información proporcionada como entrada. La salida se obtiene realizando una consulta SELECT utilizando el id recibido.
Se trata de un desarrollo robusto que asegura la consistencia y calidad en la gestión de la información del cliente en la base de datos Oracle. Creando un sistema eficiente y confiable.

### Pruebas realizadas

✅ La transacción es la WIKJT001

🔹 Base de datos Oracle creada

![bbdd vacia](/imagenes/def/1.%20BBDD%20vacia.png)

🔹 Insertando nuevos datos desde Postman

![insetando](/imagenes/def/2.%20Insertando%20nuevos%20datos%20Postman.png)

Datos insertados en la Base de Datos

![insetando bbdd](/imagenes/def/2.b%20%20Insertando%20nuevos%20datos%20DBeaver.png)

🔹 Intentando insertar datos con id que ya existe en la Base de Datos

![id](/imagenes/def/3.%20Insertando%20nuevos%20datos%20pero%20con%20mismo%20id%20Postman.png)

🔹 Intentando insertar datos con nuip que ya existe en la Base de Datos

![nuip](/imagenes/def/4.%20Insertando%20nuevos%20datos%20pero%20con%20nuip%20que%20ya%20existe%20en%20la%20BBDD%20-%20Postman.png)

🔹 Intentando insertar nuevos datos con un id que tiene más de 5 caracteres

![id caracteres](/imagenes/def/5.%20%20Insertando%20id%20con%20mas%20de%205%20caracteres.png)

🔹 Intentando insertar nuevos datos con un nuip que tiene más de 10 caracteres

![nuip caracteres](/imagenes/def/6.%20%20Insertando%20nuip%20con%20mas%20de%2010%20caracteres.png)

🔹 Intentando insertar nuevos datos con un fullname que tiene más de 50 caracteres

![fullname caracteres](/imagenes/def/7.%20%20Insertando%20fullname%20con%20mas%20de%2050%20caracteres.png)

🔹 Intentando insertar nuevos datos con un phone que tiene más de 15 caracteres

![phone caracteres](/imagenes/def/8.%20%20Insertando%20phone%20con%20mas%20de%2015%20caracteres.png)

🔹 Intentando insertar nuevos datos con un address que tiene más de 30 caracteres

![address caracteres](/imagenes/def/9.%20%20Insertando%20address%20con%20mas%20de%2030%20caracteres.png)
