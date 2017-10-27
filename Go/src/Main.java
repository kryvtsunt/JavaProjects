import controller.EnhancedController;
import controller.IGoController;
import controller.SimpleController;
import model.GoModel;
import model.IGoModel;
import view.GoGUIView;
import view.GoTextView;
import view.IGoGUIView;
import view.IGoView;


public class Main {

    public static void main(String[] args){
        while (true) {
            IGoModel model = new GoModel();
            IGoGUIView view = new GoGUIView(model);
            IGoController controller = new EnhancedController(model, view);
            controller.run();
        }

    }

}
