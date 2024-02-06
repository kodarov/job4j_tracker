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

    private static Label getLabelMaxScore(List<Label> labels) {
        double max = Double.MIN_VALUE;
        Label label = null;
        for (Label value : labels) {
            if (value.score() > max) {
                max = value.score();
                label = value;
            }
        }
        return label;
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
        return getLabelMaxScore(labels);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> subjectMap = getSubjectMap(pupils);
        for (String name : subjectMap.keySet()) {
            Label label = new Label(name, subjectMap.get(name));
            labels.add(label);
        }
        return getLabelMaxScore(labels);
    }
}