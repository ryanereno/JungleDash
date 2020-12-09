public class DoDuckValve implements Valve {
    @Override
    public ValvesResponse execute(Message message) {
        if(message.getClass() != DuckMessage.class){
            return ValvesResponse.MISS;
        }
        return ValvesResponse.EXECUTED;
    }
}
