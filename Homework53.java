import java.util.*;

public class Homework53 {
    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)",
                            "root/c 3.txt(abcd)",
                            "root/c/d 4.txt(efgh)",
                            "root 4.txt(efgh)"};

        System.out.println(Arrays.deepToString(findDuplicate(paths).toArray()));
    }


    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> sameContentPaths = new ArrayList<>();
        Map<String, List<String>> contentPathMap = new HashMap<>();

        for (String data : paths) {
            String[] pathsArray = data.split(" ");
            String directory = pathsArray[0];

            for (int i = 1; i < pathsArray.length; i++) {
                int j;
                StringBuilder content = new StringBuilder();
                StringBuilder fileName = new StringBuilder();
                for (j = 0; pathsArray[i].charAt(j) != '('; j++) {
                    fileName.append(pathsArray[i].charAt(j));
                }

                content.insert(0, pathsArray[i].substring(j + 1, pathsArray[i].length() - 1));

                contentPathMap.putIfAbsent(content.toString(), new ArrayList<>());
                contentPathMap.get(content.toString()).add(directory + "/" + fileName);
            }

        }

        for (String key : contentPathMap.keySet()) {
            if (contentPathMap.get(key).size() > 1) {
                sameContentPaths.add(contentPathMap.get(key));
            }
        }
        return sameContentPaths;
    }
}
