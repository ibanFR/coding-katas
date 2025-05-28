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


rule for middle padding?
Print diamond for 'A' => letter position 1
A

Print diamond for 'B' => letter position 2
.A.
B.B
.A.

Print diamond for 'C' => letter position 3
..A..
.B.B.
C...C
.B.B.
..A..

Print diamond for 'D'
...A...
..B.B..
.C...C.
D.....D
.C...C.
..B.B..
...A...

print diamond for 'E'.

....A....
...B.B...
..C...C..
.D.....D.
E.......E
.D.....D.
..C...C..
...B.B...
....A....

print diamond for 'F'.
.....A.....
....B.B....
...C...C...
..D.....D..
.E.......E.
F.........F