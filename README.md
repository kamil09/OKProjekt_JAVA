# Genetic algorithm in task scheduling

AUTHORS:
	KAMIL PIOTROWSKI
	MICHAŁ LEWIŃSKI

Dane:
	job-shop
	non-interuptable jobs 
	operation 1 before operation 2
	machines : 2
	sum of the end operation times optimization

PARAMETERS:
	ALGORITHM SETTINGS:

	-TR0	FILENAME:	Tryb pracy programu, generacja instancji i zapis jej do pliku (binarka), i na ekran (tekst)
	-TR1		:	Domyślny tryb pracy
	-PS 	N	:	Wielkosć populacji startowej N (def. 50)
	-PE	N	:	Wielkość populacji po rozszerzeniu N (def. 300)
	-IM	N (<1)	:	Ilość mutacji (def. 0.33)
	-IK	N (<1)	:	Ilość krzyżowania (def. 0.33)
	-T	T	:	Czas wykonania programu w sekundach (def. 8)
	-SF	FILENAME:	Plik do wczytania instancji, jeśli nie podany instancja jest generowana
	-NI	NUMER	:	Numer instancji jako nagłówek pliku wynikowego
	-ALL		: 	Wypisanie na konsole całego rozwiązania zamiast tylko funkcji celu		
	
	PROBLEM GENERATOR SETTINGS:
	
	-IZ	N	:	Ilosć zadań do wygenerowania w instancji (def. 50)
	-PP	N	:	Procent przerw do wygenerowania w instacji (def. 0.2)
	-minZ	N	:	Minimalna długość zadania (def. 1)
	-maxZ	N	:	maksymalna długosć zadania (def. 50)
	-minP	N	:	minimalna długosć przerwy (def. 1)
	-maxP	N	:	maksymalna długość przerwy (def. 50)
	-maxG	N	:	maksymalny czas gotowości zadania (def. 100)

	Program w trybie TR0 generuje instancje w formie binarnej do pliku oraz w formie tekstowej na ekran. W celu jej wczytania do programu naży po przełączniku "-SF" podać ścieżkę do pliku binarnego z instancją. Uzycie przełącznika -ALL powoduje wypisanie całego rozwiązania na ekran.

PRZYKŁADY:
	W folderze IN_OUT znajduje się 1000 przykładowo wygenerowanych instancji (numer.in) wraz z rozwiązaniami (nimer.out). Pliki o najmniejszych numerach są najwygodniejsze do analizy, ponieważ wraz ze wzrostem numeru rośnie ilość zadań, czas ich trwania, gotowości oraz ilość przerw.
