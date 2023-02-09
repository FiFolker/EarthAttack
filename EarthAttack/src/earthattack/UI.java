package earthattack;

import java.util.ArrayList;

public class UI {

    public static void showOptions() {
        System.out.println(
                  "=====================================\n"
                + "||             Options             ||\n"
                + "||---------------------------------||\n"
                + "||                                 ||\n"
                + "||                                 ||\n"
                + "||   (1) Choix Difficulté          ||\n"
                + "||   (2) Choix Dialogue Roleplay   ||\n"
                + "||                                 ||\n"
                + "||                                 ||\n"
                + "=====================================");
    }

    /**
     * Fonction pour l'art ASCII
     */
    public static void showEarth() {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%###************\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%##*************\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%#*#*******#######\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%#++=+++****#%%#%##\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%#%%%%%%%#+++===+=+**#%%%%%%@@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%######%%%##*+=--===++*##%%%%%%%%@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%###****###**+=---=+=+****%%%%%%@@@@@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%#**++========-=-::--=*###%%%@@@@@@@@@@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%##*+==----::::-::::---=*#%%%%%@@@@@@@@@@@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%***+=-=---:.......:::-=+*##%%%@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#+===-=+*=+===-.....::-+**#%%%%%@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#+=--=+=++=+*#*+=-...::-=+*#%%%%@@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#=:--***+#*#####*+=-..:::=**#%%%@@@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%+-.=+-###**######**+..::-=+*%%%@@@@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%+-:*#+=##=*#*###***=.:-===*%%@@@@@@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#+-:+*=***++##*###*+-.:==+*%%@@@@@@@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%*=:-+--**##*+***#*+-:=+*#%@@@@@@@@@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#+-:-..=**####****+-=**%%@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%*=::.==*####**+=-=*#%@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#+=:--=++===--=*#%@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "%@%%%%%%%%%%%%%%%%%%%@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#*+++++++*#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "%%%%%%%%%%########%%%%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "*****++++++++++++====+++***######%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + ":-::::----========-:::::::::::::--=++*##%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "========----=-=---===---------:.  ....:==+*###%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "*******++===-:.....------===-::....:..::-===+++**#%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "+******+=-::---..:---=-::----=--==========++++==-:-=+##%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "***#***+++++===-::-=+++++++=----====++++==++++++=-.:..:=*#%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "===++++*+*+++*++=+==---:====+++*+*+**+++++++++++++:   .:--=+*#%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "--+********+++==+++-:.  .-===+********++*********++.    :=====+*#%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "*+**********+++===+=-. .:-*#***#**#***++++****####*=-   .=++=+++++*#%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "***************++=--=-:.-+************+*###***#####*+:...=++++++++==*##%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "***********#**##*+=-.-=-=++***###****++*****#*####+:-=:...+=++**++++==+*#%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "****############+++======+*#####**********==++*+=::--=*+-.:=+===++*+++=::+#%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
                + "###%%%%%%%%%%#***+++*====-+*###**#*************++=:.:-=**+=**++=-+++++++-.:*%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    /**
     * Art ASCII
     */
    public static void showBadEnd() {
        System.out.println("                                                               ,           .    . .                                  , ,..       \n"
                + "                                                                       .                ,        .          . ,   ,.. ,..        \n"
                + "                                                         ,                    *.     .,...,   .,   .            ./.,,.. *    ,   \n"
                + "                                                        .....        .      .  .. ..,.....,..,,              ..,.*/*.,           \n"
                + "                                                    .....            ..   .%.....  ......,,..*.       *    ...,*//,,  ./         \n"
                + "                                                     ..          .   ...  .../........,.....,.  .     , ..,***//,,.      .   .   \n"
                + "                                                     .               ,   ....(,.. . /,....(,...    . , ,,**//**,.    ..          \n"
                + "             . ....                                 .   .          .*, ...,.*.,,.*.,..#(.(,..  .. ..,,,*/////,.  *               \n"
                + "              ......  ..            .                 .         . . . . .......,...//*((*,.,..,,..#,,*//(//*., .  .     .        \n"
                + "                ... ...                      .       ..   *    .... ...*.(/,.,.,,,,*,**,/**/**,,,.*/((((//,.    ,(    *          \n"
                + "              ........                                      . ....*....,*,...*,*,*/(//*/(#*(//*//(((((((,..,,..,.*....           \n"
                + "....          .,,                   .      .  ...........,,,,,,,,,,,*****(**/**/(/(((((####(((((##%##(/,**,,,.......,  ...       \n"
                + ".             .....                       .....,,,,***////(((((((###(#####%%&&%&%%%#%%&@@@@&&%&&@&%&#((//#%*/,**...,...      .,  \n"
                + ".                                ..,#%#(/((//////(#####%%%%%%&&&&@@@@&@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&%&%%(%/*#*,,,*....,...*..,.  \n"
                + "                          .%#((#((/(((###((((////((////((%#((#%%&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&%#((/**,,,,..,,...... .   \n"
                + "                   .##(((((*/*/(////(((#(*///////////*(//((**/#(((##%%&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&%#(///**/**,,.,,...*.     \n"
                + "              .##(*,*,**(,,**///*((((/*,,//**,,,***/*/(*(#((/**((#%##%%&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@&%(/#/**,**/*,*./.,..,    \n"
                + "         .%(%((/*/(/,*((((#*/,,*******,,,,.,,*,./,,.,,*,##&&&%#%&%%&&%&&&&&%%%%%%%%&@@@@@@@@@@@@@@@@@@@@@&%(**(*/(#*,,,..........\n"
                + "     .%#(///(/*//((///(/****,**,.,*,*,..*......,./..,,**#%&%&&&%(/(#((/(###%%%%%#####%&&&@@@@@@@@@@@@@@@@@%#((*//(((#(/,,....    \n"
                + "  ///(/(/**/,,.**//*,,**  .... ,,.... ......... ,. .,,,,/###&&&%#((**,*,,***/##%####(((((##%%&&@@@@@@@@@@@&&%((((((//(#*.....,   \n"
                + "(**...,....,*,*/,,.. .      ..  ....               ..,,,/,(*/***,,,,,*,,,,*,**,//((#####(((((((#%%%&@@@@@@@@&&%##(((((/,,........\n"
                + ",.,,,,....(//*...,,.  .   .                    . ........,,.,,,,/*,..,,,,,,,,,*/(/##%%%#(/****///((##%%%&&&&&&&%%#((*,,.....,(.. \n"
                + "........,/,*        .                          .     ..  .... ..........,.,,****//###((/**,********//##%%#%%%%%###(//(,...  .....\n"
                + ".  .     .                                ..      .,#*           ..,,....,,,,,,,,***,,,,*,,,*/*,,********////((#((((////,....    \n"
                + "                                       .         .,/((..(*....   .  .......,/,/,,,,,,,,,,.,...,,,,,,,(,,,,,*****//#/(//(*//..*   \n"
                + "                                   ...      .          ,     , . ..    ......,*,......*,..,.......*..,./,,,,,,,**,***/**//*/(.   \n"
                + ".                          ,. ,*                            .  ,..(   .    ... ...........*........**..,.,.. ....*.,,,,.,//,,*/. \n"
                + "                           .                                 . .   .                 .           ..  .  .(/..*.........,,,..(,*%/\n"
                + "              ...               ,      /.                           ,/  . ..     ,                     .   ....  .,.,. ...,,...*#");

    }

    /**
     * ASCII Art
     */
    public static void showGoodEnd() {
        System.out.println("                                                                                                                                 \n"
                + "                                                                                                                                 \n"
                + "                                                                                                                                 \n"
                + "                                                                                     .                                           \n"
                + "                                                                                                                                 \n"
                + "                                                                                                                                 \n"
                + "                 . .                                                                        ............                         \n"
                + "                                                                                        .....................                    \n"
                + "                                                .                                    .......,,,,,,,,,,,,......                   \n"
                + "                                                                                   .....,,,,***//////***,,,....                  \n"
                + "                                                                               ,   .....,,**//((#&&&((/**,,,,...                 \n"
                + "                                     .        ,                                    .....,,*//(%@@@@@@#(//*,,.*..                 \n"
                + "                                                                                 . ...,,**//(#%@@@@@#(//**,,.....                \n"
                + "                             .........                                            ......,,**//(%&&##//**,,,......                \n"
                + "                        ...........,.......           .                          .  ......,*,*********,,,......                  \n"
                + "                    .........,..,.......,,,...                                       ........,,,,,,,,,,.......                   \n"
                + "                   ........,*(%#/,........,,,,..                                        ..................                       \n"
                + "                  .. .........,(##(,.........,,,..                                           ...........                         \n"
                + "                  .  ........ ..*###,........,,,,..                                                /                             \n"
                + "                 . ..........   .**/#...........,,,.             ,*                                                              \n"
                + "                  ...........   ..,##...........,,,..      ,/(#%                                                                 \n"
                + "     .              ..............*#(..  ........,,,.. */(#/                                                                     \n"
                + "              .    .. ...........,(#..    ........*/((#&                                                                         \n"
                + ",,,,,,,,,,,,,,,,,,,,............,/,..    ....**/(#%&@.                                                      .                    \n"
                + ",,,,*,,,**,,**,,,,**,*,,,,,,,,**,,,,,,,,***/(##&/,,,,.                             .                   .    .                    \n"
                + ",,,,.,,.,,,,,,,,,,,,,.............,,,,*.(#%&,,,,*,/(/((###(/******,,,..                   .  ..           ...          ,         \n"
                + "....................     .    ....,***,.....,...........,,/,,,,,*,*#(****///((//**,.   *       ....*...                          \n"
                + "                              ,**,...        ....................,,,...,((((((/////(///(#///*,,.  ....../.                       \n"
                + "                          .**,                         ....... .......,,.,..,(*(/#%#%/%(/****///////****,..               ,      \n"
                + "                       ,,.                             ..   .,*///,, ...*,.....,*(*/**///.**//(/*/****/////****/*,..             \n"
                + "                   .,.                                   . ,*,.    ..*. .,,,*,........,,/#((/((***#(/*,***/*****/**,,**/*,,..    \n"
                + "                ,,.     ..  ....     .                  .   .....,   ....,/,,.,/*.*..,,,,,,*,,*((////////,.,,/,*.***,*,,,,,,,,***\n"
                + "             ,.    ., **,,,.*....... .                      ........ ./** .,...,..* ....,,..,,**,,*,*/**//*,,,,,....,.,,,,/*,,.,,\n"
                + "          ..          .... ,*/*...., .    .*                  .........,...*#((*.. .*. **.,,,,,.,.*.,**,,,***,..,/.,,......*,.,..\n"
                + "       .                ............. .                             /..,   ..,,/**.(,/**,,...,*/*,.,,.,,****/***,,,,**,....,,,...");
    }

    /**
     * ASCII Art
     */
    public static void showMenu() {
        System.out.println("                                                       .                                                                         \n"
                + "                   ..                                                                                                            \n"
                + "                                                                                                                                 \n"
                + "                                           .    *                                                                                \n"
                + "                                                                                                                                 \n"
                + "                             .      .                                                                                            \n"
                + "                               ,                       .                                                                         \n"
                + "                                                                                                                                 \n"
                + "                                                                                              .              *                   \n"
                + "                                                                  ..                                                             \n"
                + "                                                                                             .                    .              \n"
                + "                                                                       .                          .                              \n"
                + "  ,                                             ......,,,*/////(////(///*,,,,.....   ,                  ,                        \n"
                + "       *                                 ...,*/####(/*****//(/////(//(#///////(#///(,,....                                       \n"
                + "                                .  ..,,//###(**/((*/**((#((#%%%%##%##%#(###/(#(#*##((((#((/,,..   .         .                    \n"
                + ",   .                         ..,***(#**/*,*,*,,/*//(/#(**/**%#%##%((*,///((///////((((////(((//*,..                            .\n"
                + "                     ,   ...,**/****(**/*/,****,/,,,,,,,,,*,//(#,*,***,,,*//,*/////*/////(//((/(/////,..                         \n"
                + "                       ..**//,*,/*/*,,,,*,,,,,,*,,,,*//(,..,,.*/,*/,,,,,,**/*******///((*(///(/((///////,.,                      \n"
                + "                    .,***,,,,////,,,...,,*(/...**(/***/..,,,******,*(**//*****/**/*/((*///*////(((//////////,.        *          \n"
                + "                 .,**,,,,,*//*,*/*,**,***,../,.,.,*.....*****,**,*/**/*,***,*/**/((///**///////#////////(//////..                \n"
                + "              ..,,,,**//,*,.**,,,..,....,***...,.***********,,**/*******,****,,///******#******/*///((((((((((///,..             \n"
                + "            ..*,,,**,,.,,,,,,,.*,,..,*.**..,........*****,,,,,,/*,,,,,,*,***,,**/*/**...*...***/*///.,*((##((#/////*..           \n"
                + "          .,,,,,*,......*,*......,,..,..,........*.,***,,*,,,,.,,*...*,,,,,,,*******,..........,/(****..,/##*/((//*//*,.         \n"
                + "        .,,,,*,,....,*...,*,..,....,..,...,,,**,,**,,,,..........*,**.....,,,*,,***,.....,,,,...(/****,**../(#(((((/*//*,.       \n"
                + "      .,,,,,......,,.,,,,*..,.*.*..,,..,..,,,,**,*,..........,,......*,**,.,*,,*...,,*,**///*/***(*//////*...,(//((/((**/*..     \n"
                + "     .,,,.....,..,,*,,,..,..,....,,.....**,**,,,**.....................,.....,.,,..,.**/**//(***/**//*/*,//,*.***(//(/****/,.    \n"
                + "   .,,......,....,,.......,.,.....*..,,...*,.,,...............*......*................../,..**..*/*/((((//*////((((//(/******..  \n"
                + "  .,............................. ,,.  ..,,,*,.,****//////****//,..................*,........,...*((((((((/**////*(///*((//*/*,. \n"
                + " ...............,... ..............,..,*,,,****/****//////((///...  .   . . . ..... .............***/(//(((////(**/////*(/(*//**.\n"
                + " ________________________________________________________________________________________________________________________________\n"
                + "/                                                                                                                                 \\\n"
                + "|   _______   ________  ________  _________  ___  ___          ________  _________  _________  ________  ________  ___  __         |\n"
                + "|  |\\  ___ \\ |\\   __  \\|\\   __  \\|\\___   ___\\\\  \\|\\  \\        |\\   __  \\|\\___   ___\\\\___   ___\\\\   __  \\|\\   ____\\|\\  \\|\\  \\       | \n"
                + "|  \\ \\   __/|\\ \\  \\|\\  \\ \\  \\|\\  \\|___ \\  \\_\\ \\  \\\\\\  \\       \\ \\  \\|\\  \\|___ \\  \\_\\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\___|\\ \\  \\/  /|_     | \n"
                + "|   \\ \\  \\_|/_\\ \\   __  \\ \\   _  _\\   \\ \\  \\ \\ \\   __  \\       \\ \\   __  \\   \\ \\  \\     \\ \\  \\ \\ \\   __  \\ \\  \\    \\ \\   ___  \\    | \n"
                + "|    \\ \\  \\_|\\ \\ \\  \\ \\  \\ \\  \\\\  \\|   \\ \\  \\ \\ \\  \\ \\  \\       \\ \\  \\ \\  \\   \\ \\  \\     \\ \\  \\ \\ \\  \\ \\  \\ \\  \\____\\ \\  \\\\ \\  \\   | \n"
                + "|     \\ \\_______\\ \\__\\ \\__\\ \\__\\\\ _\\    \\ \\__\\ \\ \\__\\ \\__\\       \\ \\__\\ \\__\\   \\ \\__\\     \\ \\__\\ \\ \\__\\ \\__\\ \\_______\\ \\__\\\\ \\__\\  |\n"
                + "|      \\|_______|\\|__|\\|__|\\|__|\\|__|    \\|__|  \\|__|\\|__|        \\|__|\\|__|    \\|__|      \\|__|  \\|__|\\|__|\\|_______|\\|__| \\|__|  |\n"
                + "|                                                                                                                                  |\n"
                + "\\_________________________________________________________________________________________________________________________________/\n"
                + "\n"
                + "1) Jouer\n"
                + "2) Leaderboard\n"
                + "3) Options\n"
                + "4) Quitter");
    }

    /**
     * Fonction qui gère l'affichage du leaderbord
     *
     * @param lengthLeaderboard taille du leaderboard
     */
    public static void showLeaderboard(int lengthLeaderboard) {
        int choice = 0;
        do {
            ArrayList<User> sortedUsers = User.sortUsers();
            int i = 0;
            System.out.println("+--------+----------+--------+");
            System.out.println("|  Rang  |  Pseudo  |  Score |");
            System.out.println("+--------+----------+--------+");
            while (i < sortedUsers.size() && i < lengthLeaderboard) {
                String rank = Integer.toString(i + 1) + ")";
                System.out.format("|  %-6s|  %-8s|  %-6.2f|%n", rank, sortedUsers.get(i).name, sortedUsers.get(i).score);
                i++;
            }
            System.out.println("+--------+----------+--------+");
            System.out.println("\n1) Menu");
            System.out.println("/!\\Faites 1 pour retourner au Menu/!\\");
            choice = EarthAttack.input.nextInt();
        } while (choice != 1);

    }

}
