/*
 * Copyright (c) 2013 Evolveum
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://www.opensource.org/licenses/cddl1 or
 * CDDLv1.0.txt file in the source code distribution.
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 *
 * Portions Copyrighted 2013 [name of copyright owner]
 */

package com.evolveum.midpoint;

import com.evolveum.midpoint.xml.ns._public.common.common_2a.UserType;
import org.w3c.dom.Document;

import java.util.Random;

/**
 *      Random User Generator
 *
 *   <p>
 *      Purpose of this class is simple. It generates user objects with few simple static methods.
 *      At the moment, it is able to generate these items:
 *          <ul>
 *              <li>givenName - male/female given name from build in list</li>
 *              <li>familyName - randomly generated from vowels and consonants</li>
 *              <li>password - randomly generated from UTF-8 characters</li>
 *          </ul>
 *
 *      Fuctionality:
 *          <ul>
 *              <li>List of male/female first names</li>
 *              <li>Can generate female names based on nationality (Slovak women may append ending 'ova')</li>
 *              <li>Fully customizable suite, just change basic constants</li>
 *          </ul>
 *   </p>
 *
 *
 *  @author Erik Suta
 *
 * */

public class RandomUserGenerator extends TestFrameworkUtil{

    //Constants used for configuration of generator
    //feel free to modify them as needed
    public static final String[] WOMEN_FIRSTNAME_LIST = new String[]{
            "Mary", "Jennifer", "Lisa", "Sandra", "Patricia", "Maria", "Nancy", "Donna", "Linda", "Susan", "Karen", "Carol", "Barbara", "Margaret",
            "Betty" ,"Ruth" ,"Elizabeth" ,"Dorothy" ,"Helen", "Sharon", "Alžbeta", "Mária", "Viktória", "Otília", "Vladimíra", "Katarína", "Ľudmila", "Terézia"
    };

    public static final String[] MEN_FIRSTNAME_LIST = new String[]{
            "James", "John", "Robert", "Michael", "William", "David", "Richard", "Charles", "Joseph", "Thomas", "Christopher", "Daniel", "Paul", "Mark",
            "Donald" ,"George" ,"Kenneth" ,"Steven" ,"Edward", "Brian", "Tomáš", "Riško", "Róbert", "Janík", "Žigmund", "Maťko", "Kubko", "Dežko"
    };

    public static final Integer WOMEN_FIRSTNAME_LIST_SIZE = WOMEN_FIRSTNAME_LIST.length;
    public static final Integer MEN_FIRSTNAME_LIST_SIZE = MEN_FIRSTNAME_LIST.length;

    public static final Character[] CONSONANTS = new Character[]{'h','c', 'k', 'g', 'd', 't', 'n', 'l', 'j', 'b', 'm', 'p', 'r', 's', 'v', 'z', 'f'};
    public static final Character[] VOWELS = new Character[]{'a', 'e', 'i', 'o', 'u', 'y'};
    public static final Integer CONSONANT_SIZE = CONSONANTS.length;
    public static final Integer VOWELS_SIZE = VOWELS.length;

    public static final Integer RANDOM_NO_SCOPE_IDENTIFIER = 0;
    public static final Integer WOMAN_GENDER_IDENTIFIER = 1;
    public static final Integer MAN_GENDER_IDENTIFIER = 2;
    public static final Integer MAX_PASSWORD_LENGTH = 25;
    public static final Integer MIN_PASSWORD_LENGTH = 6;
    public static final Integer MAX_FAMILY_NAME_SIZE = 12;
    public static final Integer MIN_FAMILY_NAME_SIZE = 3;


    /**
     *  The purpose of this small function is to generate completely random user with meaningfull data
     *  using created random name generator
     * */
    public static UserType createRandomUser() {
        UserType user = new UserType();
        Document doc = getDocument();
        String firstName;
        String lastName;

        if(generateRandom(RANDOM_NO_SCOPE_IDENTIFIER)%2 == 0){
            //we create male user
            firstName = MEN_FIRSTNAME_LIST[generateRandom(MEN_FIRSTNAME_LIST_SIZE)];
            lastName = generateRandomFamilyName(MAN_GENDER_IDENTIFIER);
        }else{
            //we create female user
            firstName = WOMEN_FIRSTNAME_LIST[generateRandom(WOMEN_FIRSTNAME_LIST_SIZE)];
            lastName = generateRandomFamilyName(WOMAN_GENDER_IDENTIFIER);
        }

        user.setName(createPolyStringType(firstName+lastName,doc));
        user.setGivenName(createPolyStringType(firstName, doc));
        user.setFamilyName(createPolyStringType(lastName, doc));
        user.setFullName(createPolyStringType(firstName + " " + lastName, doc));
        user.setEmailAddress(firstName.toLowerCase()+"."+lastName.toLowerCase()+"@mail_provider.com");
        user.setCredentials(createPasswordCredentials(generateRandomPassword(generateRandom(MAX_PASSWORD_LENGTH), MIN_PASSWORD_LENGTH)));

        return user;
    }

    /**
     *  Here we generate random password from UNICODE characters
     * */
    public static String generateRandomPassword(int length, int minLength){
        StringBuilder password = new StringBuilder();

        if(length <= minLength)
            length += minLength;

        for(int i = 0; i < length; i++)
            password.append((char)((int)(Math.random()*26)+97));

        return password.toString();
    }

    /**
     * This method generates random family name, or last name, it is generated from consonants and vowels
     * */
    public static String generateRandomFamilyName(int gender){
        StringBuilder familyName = new StringBuilder();

        int nameSize = generateRandom(MAX_FAMILY_NAME_SIZE);

        if(nameSize <= MIN_FAMILY_NAME_SIZE)
            nameSize += MIN_FAMILY_NAME_SIZE;

        for(int i = 0; i < nameSize; i++){
            //first letter in familyName must be upper case
            if(i == 0){
                familyName.append(Character.toUpperCase(CONSONANTS[generateRandom(CONSONANT_SIZE)]));
                continue;
            }
            if(i % 2 == 0)
                familyName.append(CONSONANTS[generateRandom(CONSONANT_SIZE)]);
            else
                familyName.append(VOWELS[generateRandom(VOWELS_SIZE)]);
        }

        //If user is woman, we may append slovak lastName ending 'ova'
        if(gender == 1){
            if((generateRandom(RANDOM_NO_SCOPE_IDENTIFIER)%3) == 0)
                familyName.append("ova");
        }

        return familyName.toString();
    }

    /**
     *   Returnes random positive integer value within given scope
     * */
    public static int generateRandom(int scope){
        Random random = new Random(System.nanoTime());

        if(scope == 0)
            return Math.abs(random.nextInt());

        return  Math.abs(random.nextInt()%scope);
    }
}
