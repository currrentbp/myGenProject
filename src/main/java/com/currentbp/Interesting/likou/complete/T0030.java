package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.ListUtil;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author baopan
 * @createTime 20190402
 */
public class T0030 {
    /*
    给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
示例 1：
输入：
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。
示例 2：
输入：
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
输出：[]
     */
    @Test
    public void t2() {
    }

    private String getFormatTime4Detail(String time,boolean isOver) {
        if (org.apache.commons.lang3.StringUtils.isBlank(time)) {
            return "";
        }
        DateFormat before = new SimpleDateFormat("MM月dd日");
        SimpleDateFormat after = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = before.parse(time);
            int year = new Date().getYear();
            if (isOver) {
                year++;
            }
            date.setYear(year);
            return after.format(date);
        } catch (Exception e) {
        }
        return "";
    }

    static String source = "xjpguhvytyjcknhjqkwelhjqbdgtwxgvgxbdeydxwozidiutuqafxjxaodtkdbfjyiocgtbfhcplmjggbgoarlcgpxssyadyiuapndwxhlitvoayvqzobbuqzpkzpqyzkaqzgmwnyghvvjtszuiawdtxufylvwkhzbhfpfsnmbkjkedlylowqjvkquxmsivrlewakrqysahfgmqhxgfqpbcgxaupkrhvwfviwngrqpwybohaxnsoqvwpxqehkncgvzqtpwkflidoznqwcjksehjdzpkjdmranhtcfejsopgncxjeguymbhpcwbmbpfbcnvhsbqnpftdjsonainoludqtgcwvjyywvhryxepfzuqsjgstthhqmxltbhokfojcvcavgqchmszvyupudykrvvmwedikrroptrmbjojvgkrheibjgnbdknboqjakbpbwgnyrbhmjtfqantjvgmaqcbhulhgowhkeukvxrkhnpznfvwcdldwnedjpkqfjxqnualruvahmcwrxuuafxwubzetmwyvtqkntvhnshwhjsyimujuthoxjuqvqqqmhazayipsqnzbfaktuvpocennadirvadcdeedpvvfixipxujtpajugwhhbsaxsfbvliaadwhmvqbsmmnenxavvhcxbcwwjxtvfuvlqdxlvafhpsnernznxemygiuqfonniiyanxnkzuuoohugvwvsajsirnyydnnnwnplkcwkyqamxvuurrmrafztuauzphmlvdzhfvrflurkpmfidtbgycbuevtufhhakgjrdbwqvqbmciwhbxpcbrwgmscrbjtmsffvgemdupryxphaoxcpobxcvbwwnrkfwscewqjsfcqerzffwjxmmwrhynelgosfiujenvwsxozpogwmrtbeqslqhrbnitsqpevcztxykynaemmvhnbzhnpogqeolyfdccfdxecjcrjidyelnhmvuclduprioylscswaxylbpvkvvqikxuhuytxtkqbapottgrvfphjgetdzjljigrcembzwsczjqsczlygcfpijkmktzvehmgoaknzcqylisnjdlqfshpbsdnndjrkxayykoxogxzqpoascsxubmytsljvuahucisowrccobudsuxuouoqimlaauxwxhqbpkqldsptwjyogviurymclyenueltlcvaollufcnbnmptjzqbycflcjyxnjsynnaealygpljdzzyjyomyrtjvchustnsgctkdgklwwubxvziwouuhpecslxmgmepoxbremcckzdhucqqqmlzcpcwcbilnmabkbtqpxszwvhtzzjslwrnntlsutdjgflsigkyfcxezexydiqrfigudsmalrjtwunfcxdibcmajjbotrfybmtfghftzqpxlcepcjxdmlgvwhjqarqcdlhltoeuettryyhahgfvsnqqucgxtzzykijfwpbcjvujvdjelqadeswawcxpdwpoeyvcqxfzubipetvpjxvpqtqmxpebotpuumxkjelffvwlosczpzrhsjwqycrmvihrugbgkolrjiezcgbtisbadzsbblqytzsqfvyrklitvmvxuyrcqufvvzwyloygnqwsmwjwitrdhobcmugcqnzlnwlykjeaadsmzekhxdlhsojekrjafinseysrjyrjblxbrjkrnvyflhjvasxfbkzhkraustdtfdwymhpzengqwqnxklelvetixvcpphjwkhuzokavxhlwzatjlxxjdqrbnvsccdypltqzdswcbhyaktmxrjgwbzxowqrzvpqgkiipaescoscymovfxebyfbpctgdoxvxidfxdjrfzmkxaavhabiyilpkevpvvksfpzetiwakkkjklgrlhblqnbctyuqtgkawjfrubrenenxpuqcdrptgsyctusmadnyospivhminahewxgzoxvxqtzjntxpymongdvdmknzkudirlhijchbxgkmbjcawsnevkikuvjgspolcyvlacmakymmiqmgibkensqiqbqiqfttdpgfrvfevsqdkelthwzuqpegqvqjakefbmkuhsyfmokwswpbsqwkfatyvjjxvncwzprjhpoteypywhcqxybfaufyfovbbaxcponygdrkeikarmrrmuwnqblvpiwsiuwzkkxqnqctbpusdnlqhhfxkssbapvllskvekmtcqndfhyjujbdtgafauhclenwwaucmiwoyjugqupmfspaarganpcztqxssruebqucbqirkzfsrwsrnardpvclnzfftblusgyvwgnjfudyrvpgwijngnatnfbihmebudwtjlerihrbchjartqzistxyufhikkdpiwauarejjfnsooljglsygpyaxhijrnyalywnsawdfkxtaidgvxgbmhdloougbsipteclezqljnejvjrtgzuvgygvoddrxlgqrjdxititgoeeavxiwrfdroahrdzoqfhhokgygormevsespnpjsscgukzxjopoxyfjedpuxeyswfnoucxmwbvqlwpwmgljestkviesoennjabfeauabpsnljjapwjvochmnngbrvodxribredttvihgthxsssivbwkodniaelyvvzpadkvasejnngfgbqdcmprpczqgmoejptlsdjvxpekdmslniqqufjmhieqwuufjntescbpthbyttjhdbzaiiosssioocvzrqdjugaonbmhxyqczpcixqarkkfaocaftfqnmsbbtqisoyvppxzoqbfclmdzpdgkiyxwqbymtiehjzyyzynrzutnhymwbvimvhkmiiadtekcgjafjpyikrvtqkrthzhcgsqrcquvxhxdsakbrkldbjwttnpcowgvqzotriqorotjqfmhpylthhocxdelcmiulwpdhgtywpkmuwvmugfbqtfpzlcdylxjhnoovkprzzdtvafqjmtbizqhmsmkdlwnykdtusmvrrpnswfbjacrbuaommysxwhyjktdfgzwzqlrmssxtwowqqkfclxchgcqqvwvdxudnhwbarzvnpregclknkowqqniojgtgayvhvyjozebpwhxasjncajuqydghjcplakuxlelkipbgwygrkvvkfqcdvlnenerpplpapcmatogqmnjyiekpwpvrakxpoqgfcxhtcutvicnwrwvbdhtbwovyaupolyunxdizxcvfgiezhbamitnhjkhjfxaqxwfuznuzppgxzkwilxuuskdewkpbhprenwbpkvobmubnfxwqwsmrepvbakejcwqpuregmukaplnuklmjgzamqxpqjualsqdmhjvvefxtskpeybngcpstmilweljwdoimyfhcmgxermlrpyxuqrnebycfmmbpamcyrlceszkllvedwbxmumqwktbyhdojrskidmoxmbizymeupbimnbiawlydoomfgyqmlgjzhuygifcagnmwowykhypyndfvcvhpetolpotztybclpyblwlvuctjhyflwoaajonydhawfbysrytewgztiucrvhdrydthsgixpkvwlwoeujlrpmkzhorcywvwzoftwnsoxoklkbrekcxcrjdyywcwszsupxnlngbmwmxgprmbvkdmthmrdqnyphsehhsuptilhiryzeauqdhjmtdsmqqbakihtcdjxluhtofsufpklwvxryrdrjhrtpyntdyqouxkideeitotrmtlkkqbuxsposchvaamxxyfccknyairmbczovaiuvzjneslguzdsxjwbvjzxsrmvvljqntlitwyxqldlkjfjsbkpnmohfaecnqtblgleelduwjhismtmqgdfurozusbhkwkweyckjihitosldozvuccovqppksxvrjtxhvitdrbwfvjkjkhdmjtkbizodyluietpzbifslbahnmqxuwmfpwjaxzdwkzeqstrweworaqypfrmznagewreuqjqaiwsdrkzvgpnignxnemotmuylmcheozhyvzbmjaksqzcyoclvozocvmnjrwofvvdswhhghtazucziekdulsxjgkszjieefkxcrekaxkatozbtmhnzbmihzdhinnmtzlxsrjtqtvjjwleksukvgucfzlnpbcianhthqoxllhuhuzsotejbanhazwpcyzcoixvanulydhgxganbeydgmminizphatxitsigmvfqdnplnfptdszrgieohvxirwskodqdyxvdkmpzresxyuoeevunsuxjqqthvkmthhxuvotnsoksiayovsboobzfttoofahmhggcucroqdgaeeqbzrppupunkkbpkldtrkymopcgvjgzpwaopsekjaxtlzixkltdxrrliurddzesxfjnzpzipwbcxlcjwvpwmghwabafcgyanjnmymupkxukiwvhtkdhrmdrnfxsmxszihogtixfirpsplzixcrorvigcfyqeqqmxeusoraylprccsnaveqobyueftullmxjstdjndhavacztpzqusevqybwtwhfihodctmpxvpswurpjthfllddlezfcjknsaquvcmsxdmvzemjztqkgtpsarzcalpunhqiledlipgjttsuolgvewpenohnbyjogzyrebeorlxmgshudnpjjgowwxlxxunfwmzapdqgonvuhcrkriubpkzljnlghymdmlfcqvkflfbsjsfbdbculdfwqscatqffdljuiubvbcqlxvmcwqwjvbhmwjmpcrufegbpackdhaoexcgvucgqfncbzqsbjniotkfvmpytspzprflmjrerhgugynhhapxvzcsosqhmhjbzqonaittpznvzaegctezvgrjaksorbsssghuqanhbaeadihfenfzvykwiekcgcualeubejlglpioyrwceddabnymrioznkbaoxdtgobsejicbeghhjhjyfvrqltfvufksifyxgsdrbhufncnyjywrvphgimddtnxbsxayqdsrkmyxonxantrilaqtouyhjvicvlclouebjeaxsyxftqqeqgaecynmwyqrjuexpiyymbxgzxmsnexgkxmpxabvytmhnsgeahepicxhbjbonywaxjrxlusjnhsazyfchlrpnqyqaahpadryoivzepkrwcuwdbykmrachasjazbbfsbtdwvhnfbkivgnwgxkxzmeahqagrbnlchqacaqjbatyigwoggnfvtfcjikclyoqheslgiuhiohswdickvihrpjaxtflttbaztlgcgpmwxhsapvmnfteueguylfrgiugbfmflduhadcdsxphellypuupfbjojduniiuwlqfothrmggvkthljdfakjjysoshzcevquceokvcqdxbxgoijtkucwuxknglrkghfjlvviznowqnfexqyhkcdfbquibnskvzviwstvfhuwubatraaedglgwfozujlpkgahategcacybcrtftxiziqxpfxjqibcrdlryqzasbaugrplmmvmwljnsgwkrznkcydaqdcjgcfmvuziguweifrcopnhpcrtcuwtzyegdjsadsklogryoibczqjquckwygrygxeliymlswyhfphtxkxzaipwmzvkhoiomobunnifmgorwwmvgjujtmhflcpvraldomzbahjmqzfovrjecgpvuwafzrcqrnvicwlceuqwuxkrqvxsdmpxjrfkihccxzmzvxdbuvxqshhkdhcgttgeklousqyrpkqnitocqoskvbuaiwjeppibcxwupumhfeupakrqylbwovyxujblalncilxaflhmrdbrpuiqhlmwgmvawyowjbzumyutldicilwxggnprblzoicmgqkqrjkfjgywjgbrsxoaderwffvvnxhunsmedwjpcklnqogklwmqaemijidyfnsvfezkclzgvntnbbypymfysugdemcjzuggbgqftqmofhbgjbvhqdhixqmbcomdktjnbzturhkwonfxpagffqpegdfitulgpwtsvoopvylklqjctsjaizfoemyyglexhxpeodtjdhtpzftuxdvfeavimtgvemslmkranljtsfkrkdmjghomjjxvedqislvevmekzndtsnlerznzidorolosqhciszmnoszngdhasuflvundybwommhetlpnlbczucochvczrjlmgyrgbnuncdtvpilamnbippkwnoyeajrijiokyizaosxddifpwiznxlmkbkpdvileqzqqkpqyjodoyifuseippuctgtwbbihthxktmarxqwmpgrjyytonpsgvldymnffwepqssjqigexovjntedjwvrtgwssjzzgepywhjorpsreoctjgwucrmyxksrurqcxhcuoliidbzhrbccjyxoplmovefrxxvvfxpvjzdmcevvfxyrvxfmkrcfxjzugurnsijdiormtmialirihyurryyohxlnucbmlmrvaihvwpyhzrrgqnxhlwysvjhplkdywutzebwaswjsoaygnwnyunqpwahkkkijhcilfgmxdvptwqzlmokicczycgkprtyyxijcoxbtvrmthlevcodetcexlpmckkcjunljlmegfrboeflgwqmpvrmgibiulmdgzqrmcvukmvatbmzxemozfafndpjpdmxdcqrglmsajttkhujniznncucfklunxtsbjkixyczhvuueofsxfhmhbpmnchdccxdmhnlhqkpneluuqotvvgcyxpmzyrdaojo";
    static String[] words = new String[]{"twjyogviurymclyenueltlcvao", "tmilweljwdoimyfhcmgxermlrp", "ikuvjgspolcyvlacmakymmiqmg", "agrbnlchqacaqjbatyigwoggnf", "mbzwsczjqsczlygcfpijkmktzv", "vljqntlitwyxqldlkjfjsbkpnm", "beqslqhrbnitsqpevcztxykyna", "usqyrpkqnitocqoskvbuaiwjep", "ibkensqiqbqiqfttdpgfrvfevs", "wszsupxnlngbmwmxgprmbvkdmt", "fpzetiwakkkjklgrlhblqnbcty", "sxdmvzemjztqkgtpsarzcalpun", "wceddabnymrioznkbaoxdtgobs", "hpecslxmgmepoxbremcckzdhuc", "ztuauzphmlvdzhfvrflurkpmfi", "ptrmbjojvgkrheibjgnbdknboq", "vgjujtmhflcpvraldomzbahjmq", "ygormevsespnpjsscgukzxjopo", "qdkelthwzuqpegqvqjakefbmku", "hsazyfchlrpnqyqaahpadryoiv", "ickvihrpjaxtflttbaztlgcgpm", "hnshwhjsyimujuthoxjuqvqqqm", "ejicbeghhjhjyfvrqltfvufksi", "hustnsgctkdgklwwubxvziwouu", "jrfzmkxaavhabiyilpkevpvvks", "reuqjqaiwsdrkzvgpnignxnemo", "wyloygnqwsmwjwitrdhobcmugc", "fvwlosczpzrhsjwqycrmvihrug", "ehmgoaknzcqylisnjdlqfshpbs", "irvadcdeedpvvfixipxujtpaju", "mcwrxuuafxwubzetmwyvtqkntv", "lcjwvpwmghwabafcgyanjnmymu", "hdloougbsipteclezqljnejvjr", "hmrdqnyphsehhsuptilhiryzea", "wunfcxdibcmajjbotrfybmtfgh", "aeeqbzrppupunkkbpkldtrkymo", "rbnvsccdypltqzdswcbhyaktmx", "jqqthvkmthhxuvotnsoksiayov", "uqtgkawjfrubrenenxpuqcdrpt", "mvmwljnsgwkrznkcydaqdcjgcf", "wcdldwnedjpkqfjxqnualruvah", "bamitnhjkhjfxaqxwfuznuzppg", "moxmbizymeupbimnbiawlydoom", "xyfjedpuxeyswfnoucxmwbvqlw", "aftfqnmsbbtqisoyvppxzoqbfc", "zepkrwcuwdbykmrachasjazbbf", "akjjysoshzcevquceokvcqdxbx", "pcgvjgzpwaopsekjaxtlzixklt", "zucziekdulsxjgkszjieefkxcr", "jrnyalywnsawdfkxtaidgvxgbm", "xpkvwlwoeujlrpmkzhorcywvwz", "qzotriqorotjqfmhpylthhocxd", "wymhpzengqwqnxklelvetixvcp", "ceuqwuxkrqvxsdmpxjrfkihccx", "iwstvfhuwubatraaedglgwfozu", "ohfaecnqtblgleelduwjhismtm", "ekaxkatozbtmhnzbmihzdhinnm", "uvxhxdsakbrkldbjwttnpcowgv", "vafhpsnernznxemygiuqfonnii", "sbtdwvhnfbkivgnwgxkxzmeahq", "gwhhbsaxsfbvliaadwhmvqbsmm", "yueftullmxjstdjndhavacztpz", "qgdfurozusbhkwkweyckjihito", "hsyfmokwswpbsqwkfatyvjjxvn", "gxtzzykijfwpbcjvujvdjelqad", "schvaamxxyfccknyairmbczova", "prpczqgmoejptlsdjvxpekdmsl", "tpzbifslbahnmqxuwmfpwjaxzd", "zmzvxdbuvxqshhkdhcgttgeklo", "bapottgrvfphjgetdzjljigrce", "qchmszvyupudykrvvmwedikrro", "sorbsssghuqanhbaeadihfenfz", "xpfxjqibcrdlryqzasbaugrplm", "ftqqeqgaecynmwyqrjuexpiyym", "qusevqybwtwhfihodctmpxvpsw", "jekrjafinseysrjyrjblxbrjkr", "kriubpkzljnlghymdmlfcqvkfl", "ynelgosfiujenvwsxozpogwmrt", "bwovyaupolyunxdizxcvfgiezh", "dtnxbsxayqdsrkmyxonxantril", "mvuziguweifrcopnhpcrtcuwtz", "emmvhnbzhnpogqeolyfdccfdxe", "drbwfvjkjkhdmjtkbizodyluie", "dnlqhhfxkssbapvllskvekmtcq", "pwhxasjncajuqydghjcplakuxl", "jlpkgahategcacybcrtftxiziq", "tzsqfvyrklitvmvxuyrcqufvvz", "llvedwbxmumqwktbyhdojrskid", "mflduhadcdsxphellypuupfbjo", "eswawcxpdwpoeyvcqxfzubipet", "elkipbgwygrkvvkfqcdvlnener", "uiubvbcqlxvmcwqwjvbhmwjmpc", "bxgzxmsnexgkxmpxabvytmhnsg", "rjgwbzxowqrzvpqgkiipaescos", "clvozocvmnjrwofvvdswhhghta", "oftwnsoxoklkbrekcxcrjdyywc", "ypyndfvcvhpetolpotztybclpy", "qeqqmxeusoraylprccsnaveqob", "ftzqpxlcepcjxdmlgvwhjqarqc", "lknkowqqniojgtgayvhvyjozeb", "puregmukaplnuklmjgzamqxpqj", "banhazwpcyzcoixvanulydhgxg", "ualsqdmhjvvefxtskpeybngcps", "ynnaealygpljdzzyjyomyrtjvc", "cjcrjidyelnhmvuclduprioyls", "ubmytsljvuahucisowrccobuds", "fyxgsdrbhufncnyjywrvphgimd", "aelyvvzpadkvasejnngfgbqdcm", "wnqblvpiwsiuwzkkxqnqctbpus", "sldozvuccovqppksxvrjtxhvit", "blwlvuctjhyflwoaajonydhawf", "yanxnkzuuoohugvwvsajsirnyy", "ihrbchjartqzistxyufhikkdpi", "vobmubnfxwqwsmrepvbakejcwq", "tmuylmcheozhyvzbmjaksqzcyo", "tgzuvgygvoddrxlgqrjdxititg", "pgwijngnatnfbihmebudwtjler", "dxrrliurddzesxfjnzpzipwbcx", "hqiledlipgjttsuolgvewpenoh", "pwmgljestkviesoennjabfeaua", "xzkwilxuuskdewkpbhprenwbpk", "kyfcxezexydiqrfigudsmalrjt", "pplpapcmatogqmnjyiekpwpvra", "phjwkhuzokavxhlwzatjlxxjdq", "gsyctusmadnyospivhminahewx", "lmdzpdgkiyxwqbymtiehjzyyzy", "kfwscewqjsfcqerzffwjxmmwrh", "urpjthfllddlezfcjknsaquvcm", "lnpbcianhthqoxllhuhuzsotej", "qcbhulhgowhkeukvxrkhnpznfv", "nrzutnhymwbvimvhkmiiadtekc", "cymovfxebyfbpctgdoxvxidfxd", "tzlxsrjtqtvjjwleksukvgucfz", "hazayipsqnzbfaktuvpocennad", "bpsnljjapwjvochmnngbrvodxr", "hogtixfirpsplzixcrorvigcfy", "vpjxvpqtqmxpebotpuumxkjelf", "gjafjpyikrvtqkrthzhcgsqrcq", "eahepicxhbjbonywaxjrxlusjn", "gowwxlxxunfwmzapdqgonvuhcr", "bmciwhbxpcbrwgmscrbjtmsffv", "wauarejjfnsooljglsygpyaxhi", "dqdyxvdkmpzresxyuoeevunsux", "rufegbpackdhaoexcgvucgqfnc", "fgyqmlgjzhuygifcagnmwowykh", "nenxavvhcxbcwwjxtvfuvlqdxl", "pkxukiwvhtkdhrmdrnfxsmxszi", "vtfcjikclyoqheslgiuhiohswd", "qnzlnwlykjeaadsmzekhxdlhso", "cswaxylbpvkvvqikxuhuytxtkq", "fqjmtbizqhmsmkdlwnykdtusmv", "dnndjrkxayykoxogxzqpoascsx", "kudirlhijchbxgkmbjcawsnevk", "ibredttvihgthxsssivbwkodni", "ndfhyjujbdtgafauhclenwwauc", "dlhltoeuettryyhahgfvsnqquc", "zfovrjecgpvuwafzrcqrnvicwl", "wvhtzzjslwrnntlsutdjgflsig", "cwzprjhpoteypywhcqxybfaufy", "kxpoqgfcxhtcutvicnwrwvbdht", "yxuqrnebycfmmbpamcyrlceszk", "qtfpzlcdylxjhnoovkprzzdtva", "ofsufpklwvxryrdrjhrtpyntdy", "jakbpbwgnyrbhmjtfqantjvgma", "elcmiulwpdhgtywpkmuwvmugfb", "bgkolrjiezcgbtisbadzsbblqy", "bysrytewgztiucrvhdrydthsgi", "sboobzfttoofahmhggcucroqdg", "goijtkucwuxknglrkghfjlvviz", "fbsjsfbdbculdfwqscatqffdlj", "fovbbaxcponygdrkeikarmrrmu", "llufcnbnmptjzqbycflcjyxnjs", "wygrygxeliymlswyhfphtxkxza", "dnnnwnplkcwkyqamxvuurrmraf", "uxuouoqimlaauxwxhqbpkqldsp", "gzoxvxqtzjntxpymongdvdmknz", "byttjhdbzaiiosssioocvzrqdj", "dtbgycbuevtufhhakgjrdbwqvq", "iuvzjneslguzdsxjwbvjzxsrmv", "sjgstthhqmxltbhokfojcvcavg", "qouxkideeitotrmtlkkqbuxspo", "gemdupryxphaoxcpobxcvbwwnr", "ipwmzvkhoiomobunnifmgorwwm", "pvclnzfftblusgyvwgnjfudyrv", "hgcqqvwvdxudnhwbarzvnpregc", "yegdjsadsklogryoibczqjquck", "qqqmlzcpcwcbilnmabkbtqpxsz", "ugaonbmhxyqczpcixqarkkfaoc", "jduniiuwlqfothrmggvkthljdf", "nowqnfexqyhkcdfbquibnskvzv", "niqqufjmhieqwuufjntescbpth", "xssruebqucbqirkzfsrwsrnard", "vykwiekcgcualeubejlglpioyr", "zqonaittpznvzaegctezvgrjak", "oeeavxiwrfdroahrdzoqfhhokg", "wkzeqstrweworaqypfrmznagew", "miwoyjugqupmfspaarganpcztq", "uqdhjmtdsmqqbakihtcdjxluht", "rerhgugynhhapxvzcsosqhmhjb", "aqtouyhjvicvlclouebjeaxsyx", "bzqsbjniotkfvmpytspzprflmj", "nvyflhjvasxfbkzhkraustdtfd", "rrpnswfbjacrbuaommysxwhyjk", "nbyjogzyrebeorlxmgshudnpjj", "wxhsapvmnfteueguylfrgiugbf", "qdnplnfptdszrgieohvxirwsko", "anbeydgmminizphatxitsigmvf", "tdfgzwzqlrmssxtwowqqkfclxc"};

    @Test
    public void t1() {
//        List<Integer> b4 = findSubstring(source, words);
//        ListUtil.printList(b4);
        List<Integer> b3 = findSubstring3("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
        ListUtil.printList(b3);
//        List<Integer> b1 = findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
//        ListUtil.printList(b1);
//        List<Integer> b2 = findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"});
//        ListUtil.printList(b2);
    }

    /**
     * 官网最佳答案
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        int size = words.length;
        if (size == 0) return res;
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words)
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        int wordLen = words[0].length();
        int window = size * wordLen;
        char[] charArray = s.toCharArray();
        int slength = charArray.length;
        for (int i = 0; i < wordLen; i++)
            for (int j = i; j + window <= slength; j += wordLen) {
                Map<String, Integer> map = new HashMap<>();
                for (int k = size - 1; k >= 0; k--) {
                    String word = new String(charArray, j + k * wordLen, wordLen);
                    int count = map.getOrDefault(word, 0) + 1;
                    if (count > wordsMap.getOrDefault(word, 0)) {
                        j += k * wordLen;
                        break;
                    } else if (k == 0) {
                        res.add(j);
                    } else {
                        map.put(word, count);
                    }
                }
            }
        return res;
    }

    public List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (null == s || 0 == s.length() || null == words || 0 == words.length) {
            return result;
        }
        int sumLength = words[0].length() * words.length;
        int oneLength = words[0].length();
        Map<String,Integer> word2CountMap = new HashMap<>();
        for (String word : words) {
            word2CountMap.put(word,word2CountMap.getOrDefault(word,0)+1);
        }
        for (int i = 0; i <= s.length() - sumLength; i++) {
            String temp  = s.substring(i,i+sumLength);
            Map<String,Integer> tempMap = getMapFromString(temp,oneLength);
            boolean isE = isEqualse(word2CountMap,tempMap);
            if(isE) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isEqualse(Map<String, Integer> word2CountMap, Map<String, Integer> tempMap) {
        if(word2CountMap.keySet().size()!= tempMap.keySet().size()){
            return false;
        }
        for (Map.Entry<String, Integer> word2Count : word2CountMap.entrySet()) {
            String key = word2Count.getKey();
            Integer count = word2Count.getValue();
            Integer count2 = tempMap.getOrDefault(key, 0);
            if(!count.equals(count2)){
                return false;
            }
        }
        return true;
    }

    private Map<String, Integer> getMapFromString(String temp, int oneLength) {
        int length = temp.length() / oneLength;
        Map<String, Integer> result = new HashMap<>();
        List<String> strings = new ArrayList<>(length);
        for(int i=0;i<length;i++){
            strings.add(temp.substring(i*oneLength,(i+1)*oneLength));
        }
        for (String string : strings) {
            result.put(string,result.getOrDefault(string,0)+1);
        }
        return result;
    }

    /**
     * 我的超时了，关键点在于字符串长度一样（words中的长度一样）
     */
    public List<Integer> findSubstring(String s, String[] words) {
        long startTime = System.currentTimeMillis();
        List<Integer> result = new ArrayList<>();
        if (null == s || 0 == s.length() || null == words || 0 == words.length) {
            return result;
        }
        int sumLength = words[0].length() * words.length;

        //外层循环
        for (int i = 0; i <= s.length() - sumLength; i++) {
            char c = s.charAt(i);
            int index = charInWords(c, words);
            if (-1 != index) {
                boolean hasAll = hasAll(s.substring(i, i + sumLength), copy(words));
                if (hasAll) {
                    result.add(i);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("time:" + (endTime - startTime));
        return result;
    }

    private boolean hasAll(String source, List<String> words) {
        boolean flag = false;
        for (int i = 0; i < words.size(); i++) {
            String temp = words.get(i);
            if (source.indexOf(temp) == 0) {
                if (source.length() == temp.length()) {
                    flag = true;
                    return flag;
                }
                List<String> tempWords = removeKey(words, temp);
                flag = hasAll(source.substring(temp.length()), tempWords);
            }
            if (flag) {
                return flag;
            }
        }
        return flag;
    }

    private int charInWords(char c, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == c) {
                return i;
            }
        }
        return -1;
    }

    private List<String> copy(String[] source) {
        List<String> result = new ArrayList<>(source.length);
        result.addAll(Arrays.asList(source));
        return result;
    }

    private List<String> removeKey(List<String> source, String key) {
        List<String> result = new ArrayList<>(source.size());
        result.addAll(source);
        result.remove(key);
        return result;
    }
}
