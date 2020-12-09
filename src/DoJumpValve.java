public class DoJumpValve implements Valve {
    @Override
    public ValvesResponse execute(Message message) {
        if(message.getClass() != JumpMessage.class){
            return ValvesResponse.MISS;
        }
        return ValvesResponse.EXECUTED;
    }
}
