package view;

import model.IGoModel;

import java.io.IOException;


public class GoTextView implements IGoView {
    private IGoModel model;
    private Appendable output;

    public GoTextView(IGoModel model){
        this.model = model;
        this.output = System.out;

    }

    @Override
    public void update() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < 10; i++){
            for (int j=0; j< 10; j++){
                sb.append(model.getData()[i][j]);
            }
            sb.append('\n');

        }
        try {
            output.append(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setViewModel(IGoModel model) {

    }
}
