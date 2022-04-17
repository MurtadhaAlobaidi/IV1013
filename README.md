# IV1013 IV1013 Introduction to Computer Security

### Course contents
* Basic cryptography: symmetric and asymmetric cryptography.
* Cryptographic hashing and digital signatures.
* Security in protocols and services of the Internet.
* Certificates and infrastructures for open key encryption.
* Security in network systems: routers, firewalls, and systems to detect intrusion.
* Security in operating systems.
* Software security: vulnerability, attacks, and defence mechanisms

### Examination
* INLB - Written Assignment
* PRO1 - Project Assignment

### How to Execute 
* Clone this git repository. `git clone https://github.com/mhaao/IV1013`
#### Go to `Stream Cipher file`
* To test Stream Cipher Assignment `<key>` `inefile` `outefile`
   * Task1: `StreamCipher.java`
   * Task2: `StreamCipher.java` , `MyRandom.java` and `Report.pdf`
   * Task3: `StreamCipher.java` & `MyRandom.java`
> ex: 
> 1. `javac StreamCipher.java`  
> 1. `java StreamCipher 12345678 inefile.txt outefile.txt`

#### Go to `One-way-hash`
* To test One-way-hash Assignment
   * Task1: By using `OpenSSL command`
   * Task2: `OpenSSL command`
   * Task3: `Counter.java` 
   * Task4: `CollisionResistance.java` 
> ex: 
> 1. `openssl dgst -md5 filename.txt`  
> 1. `openssl dgst -md5 -hmac "key" filename.txt`
> 1. `javac Counter.java`, `java Counter 12345678 H1.txt H2.txt`
> 1. `javac CollisionResistance.java`, `java CollisionResistance`,`Enter your meesage` 
