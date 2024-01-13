package edu.hz.statement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HZMissionStatement {

    // First Ambition
    private List<String> _firstAmbition;

    public HZMissionStatement() {

        _firstAmbition = new ArrayList<String>();

        _firstAmbition.add("The HZ offers a broad portfolio of programmes and applied research.");
        _firstAmbition.add("The HZ - as the personal University of Applied Sciences - offers students and" +
                " employees a personal and interdisciplinary development route and optimal guidance.");
        _firstAmbition.add("The HZ stands for Life Long Development. This means that we strive to allow" +
                " everyone to achieve maximum development of their talents, regardless of their age," +
                " experience, or role in society.");
        _firstAmbition.add("The HZ offers its students innovative, market-oriented and personal higher" +
                " professional education and applied research. The HZ trains the professionals of" +
                " the future through continuous dialogue with the professional field. In collaboration" +
                " with the field, demand-based work takes place on the innovation of education and" +
                " research.");
        _firstAmbition.add("The education and research at the HZ are characterised by: professional relevance," +
                " responding to the demand from the market, options fitting the ambitions of students" +
                " and economic profitability. The build-up of our education enables students to take" +
                " different pathways to achieve qualifications for the employment market (courses," +
                "                                                                         Associate degrees programmes, bachelor and master programmes). On the other" +
                " hand, this modularity offers the HZ the possibilities to respond to the changing" +
                " demands of the market more rapidly.");
        _firstAmbition.add("Our small scale allows us to respond to the job market of tomorrow rapidly and" +
                " personally.");
    }

    public String[] getFirstAmbition() {

        return _firstAmbition.toArray(new String[0]);
    }
}
