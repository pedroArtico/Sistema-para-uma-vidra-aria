# Unicamp FT - (SI400B) Programação Orientada a Objetos II
## Projeto: gerenciador de visitas para vidraçaria
### Equipe

| Nome                         | RA     | ID GitHub                                      |
|------------------------------|--------|------------------------------------------------|
| André Luiz Rodrigues Estevam | 166348	| [ALREstevam](https://github.com/ALREstevam)    |
| Mayara Naomi Fustaino Ramos  | 184517	| [mayaranfr](https://github.com/mayaranfr)      |
| Pedro Artico Rodrigues       | 185545	| [pedroArtico](https://github.com/pedroArtico)  |

### Projeto
#### Introdução
Na disciplina de Análise de Sistemas de Informação I foram elicitados os requisitos para o desenvolvimento de um sistema para a vidraçaria ArtVidros. Na disciplina de Programação Orientada a Objetos II o grupo decidiu por desenvolver a parte deste sistema que diz respeito ao **gerenciamento das visitas** às residências ou estabelecimentos dos clientes.

#### Objetivo
Garantir ao usuário praticidade, agilidade e confiança em agendar e gerenciar o contato com os clientes da empresa seja para negociação, exibição de produtos, tomada de medidas ou montagem do produto final.

#### Descrição inicial
1. Inicialmente, farão parte do sistema as seguintes classes:

	* **Cliente:** operações e atributos de clientes, podendo ser pessoas físicas ou jurídicas.
	* **Funcionário:** operações e atributos de funcionários como administradores, entregadores, técnicos, etc.
	* **Veículo:** operações e atributos referentes aos veículos utilizados nas entregas.
	* **Visita:** operações e atributos sobre cada visita feita ao cliente podendo ser desde para definir qual trabalho será realizado até a entrega e montagem do produto final, por exemplo.
	* **Projeto:** operações e atributos que serão atrelados a cada visita para armazenar componentes de informação levantados (preferências do cliente, medidas e desenhos de projeto, por exemplo).

2. Para estas classes o sistema fornecerá meios para o usuário efetuar o gerenciamento por meio das operações C.R.U.D. (*Create, Read, Update e Delete*).

3. Possibilitará a criação de uma visita pelo relacionamento entre um ou mais funcionários, veículo e cliente.

4. Após uma visita feita permitirá a anexação de dados descrevendo desde os desejos do cliente até desenhos técnicos. Essa anexação será chamada de "projeto".

5. Permitirá que haja o controle das visitas por meio de estados como: marcada, remarcada, em andamento, desmarcada ou atrasada. Esses rótulos terão como base a data e a hora da visita.

6. Quando requerido poderá fornecer informações para o administrador como tempo médio das visitas tendo como perspectiva determinado funcionário ou cliente por exemplo.

## Árvore de arquivos (18/10/2017)

    ├───control
    │       Controller
    │
    ├───glazing
    │       Glazing (M)
    │
    ├───local
    │   └───persistence
    │           LocalPersistence
    │           LocalPersistenceV2
    │           ObjectKeeper (I)
    │
    ├───my
    │   ├───exceptions
    │   │       FileCouldNotBeCreatetException (E)
    │   │       FileDoesNotExistException (E)
    │   │       InvalidFileNameStringException (E)
    │   │       NotAllowedValueException (E)
    │   │
    │   └───time
    │       │   Schedulable (I)
    │       │   StandardAgendaGenerator
    │       │
    │       ├───agenda
    │       │       AgendaAllocator
    │       │       ElementPosition
    │       │       FreeBlocksManager
    │       │       TimeObj
    │       │
    │       └───helper
    │               DateTimeInterval
    │               TimeStatistics
    │
    ├───persons
    │       Administrator
    │       Assembler *
    │       Client (A)
    │       Draftsman *
    │       Driver
    │       Employee (A)
    │       LegalPerson
    │       Person (A)
    │       PhysicalPerson
    │       Secretary
	│
	├───util
	│       ReportGenerator
	│       Util
    │
	├───view
	│
    └───visit
            Project
            Vehicle
            Visit
	
	
	(E) - Exception
	(I) - Interface
	(A) - Abstract
	(M) - Main