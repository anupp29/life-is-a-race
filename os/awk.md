
# AWK Operations on `input.txt`

This README explains various AWK operations that can be performed on the sample text file `input.txt`. Below are the details of each operation, along with the commands used.

## 1. Print the Lines that Match a Given Pattern

#### Command:
```bash
awk '/orange/' input.txt
```
This command prints all lines from input.txt that contain the word "orange".

#### Example Output:
```bash
apple banana orange mango are fruits ,
orange green are colours 
```
## 2. Split Each Line into Fields
#### Command:

```bash
awk '{for(i=1;i<=NF;i++) print $i}' input.txt
```
This command splits each line of the file into individual fields (words) and prints them one by one.

#### Example Output:
```bash
apple
banana
orange
mango
are
fruits
,
orange
green
are
colours
good
morning
sweetheart
```

## 3. Find the Length of the Longest Line
#### Command:

```bash
awk '{if (length($0) > max) max=length($0)} END {print max}' input.txt
```
This command finds and prints the length of the longest line in the file.

#### Example Output:

```bash 
38
```
(The longest line is "apple banana orange mango are fruits ," which has 38 characters.)

## 4. Print Lines with More Than 30 Characters
#### Command:

```bash
awk 'length($0) > 30' input.txt
```
This command prints all lines that contain more than 30 characters.

#### Example Output:
```bash
apple banana orange mango are fruits ,
```

## How to Use
 Ensure input.txt is present in the same directory as the script.

Sample input.txt content for reference:

```bash
apple banana orange mango are fruits ,
orange green are colours 
good morning 
sweetheart
```
