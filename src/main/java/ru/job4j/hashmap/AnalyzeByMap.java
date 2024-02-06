package ru.job4j.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeByMap {
    private static Map<String, Integer> getSubjectMap(List<Pupil> pupils) {
        Map<String, Integer> subjectMap = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectMap.put(subject.name(), subject.score() + subjectMap.getOrDefault(subject.name(), 0));
            }
        }
        return subjectMap;
    }

    private static Label getLabelMinScore(List<Label> labels) {
        double min = Double.MAX_VALUE;
        Label label = null;
        for (Label value : labels) {
            if (value.score() < min) {
                min = value.score();
                label = value;
            }
        }
        return label;
    }

    private static List<Label> sortLabel(List<Label> labels) {
        List<Label> sortList = new ArrayList<>();
        int size = labels.size();
        for (int i = 0; i < size; i++) {
            Label label = getLabelMinScore(labels);
            sortList.add(label);
            labels.remove(label);
        }
        return sortList;
    }

    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (int i = 0; i < pupil.subjects().size(); i++) {
                sum += pupil.subjects().get(i).score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (int i = 0; i < pupil.subjects().size(); i++) {
                sum += pupil.subjects().get(i).score();
            }
            Label label = new Label(pupil.name(), (double) sum / pupil.subjects().size());
            labels.add(label);
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> subjectMap = getSubjectMap(pupils);
        for (String name : subjectMap.keySet()) {
            Label label = new Label(name, (double) subjectMap.get(name) / pupils.size());
            labels.add(label);
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (int i = 0; i < pupil.subjects().size(); i++) {
                sum += pupil.subjects().get(i).score();
            }
            Label label = new Label(pupil.name(), sum);
            labels.add(label);
        }
        labels = sortLabel(labels);
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> subjectMap = getSubjectMap(pupils);
        for (String name : subjectMap.keySet()) {
            Label label = new Label(name, subjectMap.get(name));
            labels.add(label);
        }
        labels = sortLabel(labels);
        return labels.get(labels.size() - 1);
    }
}