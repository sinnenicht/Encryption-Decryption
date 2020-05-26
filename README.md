# Encryption-Decryption

A program that can encrypt or decrypt text using two methods: shift and unicode.

Prerequisites
-------------

This program requires Java to run and compile.

Installation
------------

1. Download this repository and unzip the .zip file in your desired location.
2. Using the command line, navigate to \Encryption-Decryption-master\src\encryptdecrypt.
3. Compile the program using the command `javac Main.java`.

Usage
-----

Once the program has been compiled, it can be run from the command line by navigating to \Encryption-Decryption-master\src and using the command `java encryptdecrypt.Main` in combination with any desired arguments.

There are several arguments that can be entered when starting the program: `-mode`, `-key`, `-alg`, `-data`, `-in`, and `-out`. These can be entered in any order, but should be followed by the appropriate input.

`-mode`:

The mode can be set to either `enc` or `dec` for encryption or decryption. If the `-mode` argument is not used, the program will default to encryption.

`-key`:

The key is an integer value representing how far each character in a text is changed in the encryption-decryption process. If the `-key` argument is not used, the key value defaults to zero and the text will not be changed.

`-alg`:

The algorithm can be set to either `shift` or `unicode`. If the `-alg` argument is not used, the program will default to the shift algorithmn.

_Shift:_ Only alphabet characters will be shifted, retaining case (A-Z and a-z).

_Unicode:_ All characters are shifted and may become any unicode character.

`-data`:

The `-data` argument should be followed by a string of text in quotation marks. The program will encrypt/decrypt this text and will prioritize it over any text entered using the `-in` argument.

`-in`:

The `-in` argument should be followed by a file path and name. This should be a .txt file containing the text to be encrypted/decrypted.

`-out`:

The `-out` argument should be followed by a file path and name with a .txt extension. This is the file the resulting text will be written to after encryption/decryption. If the specified file does not already exist, it will be created; otherwise, the existing file will be overwritten.

Credits
-------

**Author:** Kate Jordan - [sinnenicht](https://github.com/sinnenicht/)

This program is based on the Encryption-Decryption project on [Jet Brains Academy](https://hyperskill.org/projects/46?goal=7).

License
-------

This project is licensed under the GNU General Public License v3.0. See the [LICENSE](https://github.com/sinnenicht/Encryption-Decryption/blob/master/LICENSE) for details.
