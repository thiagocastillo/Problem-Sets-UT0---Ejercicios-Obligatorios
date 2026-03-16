# Ejercicios UT0 - Transición a Java

Acá dejo la resolución de los ejercicios obligatorios de la UT0, para arrancar con Java.

## Equipo
- Thiago Castillo

---

## Ejercicio 1

### ¿Cómo compilo y ejecuto el programa desde la terminal?
1. Abro la terminal y voy a la carpeta donde está el código (`SRC/src/main/java`).
2. **Para compilar**: Escribo `javac uy/edu/curso/ejercicio1/PruebaAtributos.java`
3. **Para ejecutar**: Escribo `java uy.edu.curso.ejercicio1.PruebaAtributos`

### ¿Qué es JVM, JRE y JDK?
- **JVM**: Es la máquina virtual. Es la que lee el código compilado (el bytecode) y lo corre en la compu sin importar si es Windows, Mac o Linux.
- **JRE**: Es el entorno de ejecución, básicamente trae la JVM y las librerías que se necesitan para correr cualquier programa en Java.
- **JDK**: Es el kit de herramientas para nosotros los desarrolladores. Trae todo lo del JRE y además trae el compilador (`javac`) para poder programar.

### Primitivos vs Referencias que usé
| Tipo | Categoría | Ejemplo en mi código | Valor que toma por defecto |
| --- | --- | --- | --- |
| `int` | Primitivo | `int entero;` | `0` |
| `boolean` | Primitivo | `boolean logico;` | `false` |
| `double` | Primitivo | `double decimal;` | `0.0` |
| `char` | Primitivo | `char caracter;` | El caracter nulo |
| `String` | Referencia | `String cadena;` | `null` |

---

## Ejercicio 2

### En qué orden se evalúan las cosas
- En `result = 1 + 2;` se suma primero el `1 + 2` y después se guarda en la variable `result` (porque el sigo de igual `=` se evalúa último).
- En `a += ++i;`, el `++` hace que `i` sume 1 antes de hacer nada más. Después de sumar ese 1, se le suma a la variable `a`.
- En `Double.parseDouble(args[0])`, primero busca el elemento en la posición `[0]` y después ejecuta la función.

### Conversiones que terminé usando
| Origen | Destino | Cómo lo hice | Qué hace |
| --- | --- | --- | --- |
| `String` | `double` | `Double.parseDouble` | Pasa un texto a número con coma. |
| `double` | `String` | Usando el `+` | Transforma el número a texto si lo concateno con otro string para mstrarlo en consola. |

---

## Ejercicio 3
**¿Cuándo me conviene usar while, do-while o for?**
- **for**: Lo uso cuando ya sé exactamente cuántas veces voy a iterar, por ejemplo al recorrer un arreglo.
- **while**: Lo uso cuando no sé cuántas veces voy a iterar, pero capaz que la condición de entrada ya es falsa y no quiero que se ejecute ni una sola vez.
- **do-while**: Es casi igual al while, pero garantiza que el bloque se ejecute de pique al menos una sola vez antes de preguntar.

---

## Ejercicio 4
### Diseño
1. Separé la lógica de la suma de los números pares e impares para dejar todo más ordenado y que cada función haga lo suyo.
2. Usé `long` para el factorial para tener margen, porque con `int` enseguida explota si le pasas un número un poco grande. También le puse validaciones por las dudas.