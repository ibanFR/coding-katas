Given a letter print a diamond starting with 'A' with the supplied letter at the widest point.

This is the print diamond for 'E'.

....A....
...B.B...
..C...C..
.D.....D.
E.......E
.D.....D.
..C...C..
...B.B...
....A....


This is the print diamond for 'C'.

..A..
.B.B.
C...C
.B.B.
..A..

This is the print diamond for 'A'.

A

Note: These examples use dots in place of spaces only for readability.
Your diamond must contain spaces where there are dots.

TEST LIST
---------
[X] - Print diamond for 'A'
A

[X] - Find letter position in alphabet
- A = 0
- B = 1
- C = 2

[] - print line '1' when letter is 'A' => "A"
[] - print line '1' when letter is 'B' => ".A."
[] - print line '1' when letter is 'C' => "..A.."

[] - Add left spaces to line '1' when letter is 'A'
- 0

[] - Add left spaces to line '1' when letter is 'B'
.A.
B.B
.A.
- line 1 = 1
- line 2 = 0

..A..
.B.B.
C...C
.B.B.
..A..


