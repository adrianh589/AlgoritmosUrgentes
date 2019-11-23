Algoritmo DptoSeguridad
	Definir pos como entero;
	Definir ultimoDigito como Caracter;
	
	Definir amarilla ,rosa,rojo,verde,azul como entero
	
	Escribir "ingresa numero de autos:"
	Leer n
	
	Para i<-1 Hasta n Con Paso 1 Hacer
		Escribir "Introduzca la placa del auto ",i;
		Leer placa;
		pos = Longitud(placa);
		ultimoDigito = Subcadena(placa, pos,pos)
		
		Si ultimoDigito = '1' o ultimoDigito = '2' Entonces
			amarilla<-amarilla+1;
			Escribir "Amarilla"
		SiNo
			Si ultimoDigito = '3' o ultimoDigito = '4' Entonces
				rosa<-rosa+1;
				Escribir  "Rosa"
				
			SiNo
				Si ultimoDigito = '5' o ultimoDigito = '6' Entonces
					roja<-roja+1;
					Escribir  "Roja"
					
				SiNo
					Si ultimoDigito = '7' o ultimoDigito = '8' Entonces
						verde<-verde+1
						Escribir  "Verde"
						
					SiNo
						Si ultimoDigito = '9' o ultimoDigito = '0' Entonces
							azu<-azul+1
							Escribir  "Azul"
							
						SiNo
							
						FinSi
					FinSi
				FinSi
			FinSi
		Fin Si
	Fin Para
	
	Escribir "Cantidad de autos amarillas: ",amarilla	
	Escribir "Cantidad de autos rosa: ",rosa
	Escribir "Cantidad de autos rojo: ",rojo
	Escribir "Cantidad de autos verde: ",verde
	Escribir "Cantidad de autos azul : ",azul
	
	
FinAlgoritmo
