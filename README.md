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

![minusculas details offerType](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/97406e65-9ebf-4722-b514-ffd87220e307)


- La cantidad máxima permitida no puede ser nula _details.limitAmount.amount_

![limitAmount null request](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/cef7cfa4-f863-4a99-80ff-1f72dc648260)
![limitAmount null response](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/d235a7f7-08c2-42a8-95a7-200f3a544847)


- La moneda _details.limitAmount.currency_ no puede ser nula ni vacía

![currency null](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/0883c20b-4898-4ad6-bc9a-6f87017f93a2)
![currency vacia](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/7f385458-6a24-483f-a54f-ac85569f8b10)


- El identificador de producto _details.product.id_ tiene que ser TDC, sino la respuesta será **400 Bad Request**

![TDC](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/04b1dba4-2c77-4f7f-84d4-5dc902fdc9c8)


- El subproducto _details.product.subproduct.id_ solo puede contener de 0 a 2 caracteres

![mas de 2 caracteres](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/6f25d770-6049-4943-b07b-b707218e3e51)

![2caracter](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/4a5b1af5-8386-419a-aa51-8188a3e1975d)
![2caracterresponse](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/8b8cc2a0-b831-44af-ae03-b8480b584245)

![1caracter](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/f37753f9-52d6-4c0f-89d1-69b18b89a68f)
![1caracterresponse](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/b8093f05-4d46-43a6-911b-95aeb31a995c)

![0caracter](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/9ea331ba-fd17-465c-8f1c-8147b9c4f8eb)
![0caracterresponse](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/fc266f9c-04fb-4464-abb2-0fd0c41470af)



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

![requestPostman](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/f4cf77e5-39e4-4996-8611-e7c274f04c01)



✔️ RESPONSE:

![responsePostman](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/13cae5c9-7dfd-4dd2-89f8-c05096d1cc45)



🔹 Al considerarse mala práctica, en el código ningún import tiene \* ; ejemplos:

![imports sin asterisco DAO](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/28763639-9bae-4ffb-8feb-571686c7a13c)

![imports sin asterisco](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec4/assets/113792109/070d34e9-dee3-4370-8e6a-2160249c69b1)




---

# APX

Almacenar la información de un cliente en una base de datos Oracle mediante un proceso de inserción.

## Objetivos del proyecto

La salida esperada debe reflejar la misma información proporcionada como entrada. La salida se obtiene realizando una consulta SELECT utilizando el id recibido.
Se trata de un desarrollo robusto que asegura la consistencia y calidad en la gestión de la información del cliente en la base de datos Oracle. Creando un sistema eficiente y confiable.

## Packages del proyecto

🔹 dtos -  WIKJC001
        1. CustomerIn
        2. CustomerOut
           Con los campos:
            ```java
            	private String id;
	            private String nuip;
	            private String fullName;
	            private String phone;
	            private String address;
            ```

 🔹 libraries - a- WIKJR001
                      1. WIKJR001
                b- WIKJR001_IMPL
                     src- main - java - [...]
                       1. WIKJR001Abstract
                       2. WIKJR001Impl
                     src - main - resources
                       1. sql-WIKJT001IMPL.properties

  🔹 transactions -  WIKJT001-01-ES
                        src- main - java - [...]
                          1. AbstractWIKJT00101ESTransaction
                          2. WIKJT00101ESTransaction
                        src - main - resources
                          1. WIKJT001-01-ES.xml

           

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
