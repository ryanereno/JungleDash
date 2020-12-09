public class ResetGameValve implements Valve {
    @Override
    public ValvesResponse execute(Message message) {
        if(message.getClass() != ResetGameMessage.class){
            return ValvesResponse.MISS;
        }
        return ValvesResponse.EXECUTED;
    }
}
