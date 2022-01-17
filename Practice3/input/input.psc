Funcion resultado <- sumaTres (a, b, c)
    Definir resultado Como Entero;
    resultado <- a+b+c;
FinFuncion

Algoritmo Op_Aritmeticas
   // Programa que realiza las 6 operaciones aritméticas
   // básicas para dos números enteros y muestra los resultados por pantanlla.
   Definir x,z Como Entero;  // Estos son los dos operandos
   Dimension resultados[6];  // Arreglo para guardar resultado operaciones
   Dimension operaciones[6];  //Arreglo para guardar símbolo operaciones

   operaciones[1] <- ' + ';  // Suma
   operaciones[2] <- ' - ';  // Resta
   operaciones[3] <- ' * ';  // Producto
   operaciones[4] <- ' / ';  // División
   operaciones[5] <- ' ^ ';  // Potencia
   operaciones[6] <- ' MOD ';  // Resto

  // Pedimos los dos números al usuario por teclado
   Escribir 'Dame el primer número: ' Sin Saltar;
   Leer x;
   Escribir 'Dame el segundo número: ' Sin Saltar;
   Leer z;

  // Asignar a cada posición del array resultados, la expresión aritmética que le corresponde
   resultados[1] <- x+z;
   resultados[2] <- x-z;
   resultados[3] <- x*z;
   resultados[4] <- x/z;
   resultados[5] <- x^z;
   resultados[6] <- x MOD z;

   Escribir 'Pulsa una tecla para continuar...';
   Esperar Tecla;
   Borrar Pantalla;

   Escribir ConvertirATexto(x) + operaciones[1] + ConvertirATexto(z) + ' = ';
   Escribir resultados[1];
   Esperar 2 Segundos;
   Escribir ConvertirATexto(x) + operaciones[2] + ConvertirATexto(z) + ' = ';
   Escribir resultados[2];
   Esperar 2 Segundos;
   Escribir ConvertirATexto(x) + operaciones[3] + ConvertirATexto(z) + ' = ';      Escribir resultados[3];
   Esperar 2 Segundos;
   Escribir ConvertirATexto(x) + operaciones[4] + ConvertirATexto(z) + ' = ';
   Escribir resultados[4];
   Esperar 2 Segundos;
   Escribir ConvertirATexto(x) + operaciones[5] + ConvertirATexto(z) + ' = ';
   Escribir resultados[5];
   Esperar 2 Segundos;
   Escribir ConvertirATexto(x) + operaciones[6] + ConvertirATexto(z) + ' = ';
   Escribir resultados[6];
   Esperar 2 Segundos;

   Si (condicion) Entonces
      Escribir "a";
   SiNo
      Escribir "a";
   FinSi

   // Ejemplo
  Escribir "Introduce el valor de A: " Sin Saltar;
  Leer A;
  Escribir "Introduce el valor de B: " Sin Saltar;
  Leer B;

  Si (A = B) Entonces
     Escribir "A es igual a B";
  SiNo
     Escribir "A es distinto de B";
  FinSi

  Segun (variable) Hacer
    caso (numero1):  Escribir "a";
    caso (numero2), (numero3):  Escribir "a";
    De Otro Modo:  Escribir "a";
 FinSegun

    // Ejemplo
 Definir opcion Como Entero;
 Escribir "Elige una opción (1 - 3): " Sin Saltar;
 Leer opcion;

 Segun opcion Hacer
    caso 1:
       Escribir "Has elegido la opción 1";
    caso 2:
       Escribir "Has elegido la opción 2";
    caso 3:
       Escribir "Has elegido la opción 3";
    De Otro Modo:
       Escribir "Has elegido una opción distinta";
 FinSegun

    Dimension mi_tabla[10];
    Definir i Como Entero;

    i <- 1;
    Mientras (i <= 10) Hacer
      mi_tabla[i] <- i*10;
      i <- i+1;
    FinMientras

    i <- 1;
    Mientras (i <= 10) Hacer
      Escribir "mi_tabla[" Sin Saltar;
      Escribir i Sin Saltar;
      Escribir "] = " Sin Saltar;
      Escribir i Sin Saltar;
      Escribir "x10 = " Sin Saltar;
      Escribir mi_tabla[i];
      i <- i+1;
    FinMientras

    Dimension mi_tabla[10];
       Definir i Como Entero;

       i <- 1;
       Repetir
          mi_tabla[i] <- i*10;
          i <- i+1;
       Hasta Que(i>10)

       i <- 1;
       Repetir
          Escribir "mi_tabla[" Sin Saltar;
          Escribir i Sin Saltar;
          Escribir "] = " Sin Saltar;
          Escribir i Sin Saltar;
          Escribir "x10 = " Sin Saltar;
          Escribir mi_tabla[i];
          i <- i+1;
       Hasta Que(i>10)

    Dimension mi_tabla[10];
       Definir i Como Entero;

       Para i <- 1 Hasta 10 Con Paso 1 Hacer
             mi_tabla[i] <- i*10;
       FinPara

       Para i <- 1 Hasta 10 Con Paso 1 Hacer
          Escribir "mi_tabla[" Sin Saltar;
          Escribir i Sin Saltar;
          Escribir "] = " Sin Saltar;
          Escribir i Sin Saltar;
          Escribir "x10 = " Sin Saltar;
          Escribir mi_tabla[i];
       FinPara

    Definir a, b, c, S Como Entero;
       Escribir "Dame el primer número: " Sin Saltar;
       Leer a;
       Escribir "Dame el segundo: " Sin Saltar;
       Leer b;
       Escribir "El tercero, por favor: " Sin Saltar;
       Leer c;
       S <- sumaTres (a, b, c);
       Escribir "La suma de " Sin Saltar;
       Escribir a Sin Saltar;
       Escribir " + " Sin Saltar;
       Escribir b Sin Saltar;
       Escribir " + " Sin Saltar;
       Escribir c Sin Saltar;
       Escribir " es igual a " Sin Saltar;
       Escribir S;
FinAlgoritmo