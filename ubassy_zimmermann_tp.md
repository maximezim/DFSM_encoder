<link href="C:\Users\bastu\OneDrive\3A\Markdown\S6\style_sheets\tp.css" rel="stylesheet"></link>

# FISE ICy 3A - Automates et Langages. <br> *Ubassy Bastien et Zimmermann Maxime* <br> *2022-2023*

<div toc>

## Sommaire

- [FISE ICy 3A - Automates et Langages.  *Ubassy Bastien et Zimmermann Maxime*  *2022-2023*](#fise-icy-3a---automates-et-langages--ubassy-bastien-et-zimmermann-maxime--2022-2023)
  - [Sommaire](#sommaire)
  - [Partie 1](#partie-1)
    - [Squelette](#squelette)
    - [Constructeur à partir d'un fichier ``Automate(String nomDeFichier)``](#constructeur-à-partir-dun-fichier-automatestring-nomdefichier)
      - [Zoom sur les transitions](#zoom-sur-les-transitions)
    - [Méthode ``boolean appartient(String mot)``](#méthode-boolean-appartientstring-mot)
  - [Partie 2](#partie-2)
    - [Représentation graphique de l'automate](#représentation-graphique-de-lautomate)
    - [Résultats des tests](#résultats-des-tests)
  - [Conclusion](#conclusion)

</div>

<br>

---

## Partie 1

### Squelette



<br>

---

### Constructeur à partir d'un fichier ``Automate(String nomDeFichier)``

- Cette méthode lit un fichier grâce à la classe ``FileReader``. Ce fichier est copié dans un **tableau de caractères** puis dans une **chaîne de caractères**. La chaîne est divisée en lignes dans un **tableau de chaînes de caractères**. C'est ce tableau que la méthode parcourt pour récupérer les informations de l'automate :

```java
File doc = new File(nomDeFichier);
doc.createNewFile();
FileReader freader = new FileReader(doc);
char [] fichierTab = new char[(int) doc.length()];
freader.read(fichierTab);
freader.close();
String fichierString = new String(fichierTab);
String[] lines = fichierString.split("\n");
```

<br>

- Pour récupérer les bonnes informations au bon endroit, la méthode à un compteur qui s'incrémente à chaque fois que le caractère ``#`` est rencontré, un ``switch case`` s'occupe de définir :
  
L'**alphabet**

```java
case 1:
    alphabet.add(line.charAt(0));
    break;
```

<br>

L'**état initial** :

```java
case 3:
    initialState = line.substring(0, line.length() - 1);
    break;
```
> ``line.substring(0, line.length() - 1);`` enlève le dernier caractère de la ligne, en l'occurence : ``\n``

<br>

Les **états finaux**

```java
case 4:
    finalStates.add(line.substring(0, line.length() - 1));
    break;
```

<br>

Les **transitions**

<br>

---

#### Zoom sur les transitions

- Pour les transitions, la ligne est parcourue caractère par caractère et il y a un ``switch case`` supplémentaire afin de définir :

L'**état initial de la transition**

```java
case 1:
    etatInit += caract;
    break;
```

<br>

Le **symbole de la transition**

```java
case 2:
    symbol = caract;
    break;
```

<br>

L'**état final de la transition**

```java
case 3:
    etatFin += caract;
    break;
```

<br>

- A la fin de ce ``switch case``, un objet ``Transition`` est créé :

```java
transitions.add(new Transitions(etatInit, etatFin, symbol));
```

<br>

---

### Méthode ``boolean appartient(String mot)``

<br>

---

## Partie 2

### Représentation graphique de l'automate



<br>

---

### Résultats des tests



<br>

---

## Conclusion

