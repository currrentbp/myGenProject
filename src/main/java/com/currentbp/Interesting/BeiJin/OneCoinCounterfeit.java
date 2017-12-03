package com.currentbp.Interesting.BeiJin;

/**
 * 
 * @author current_bp
 * @createTime 20160826
 *
 */
public class OneCoinCounterfeit {

	public int allCoinsNum = 15;
	public int eachBlockNum = 0;

	public void calculation() {
		int i = 1;
		eachBlockNum = allCoinsNum;
		while (true) {
			if (eachBlockNum % 2 == 0) {//表示能分成两堆
				if (eachBlockNum == 1) {
					System.out.println("已经能区分了");
					break;
				}
				// 如果能分出3份，则先分出三份，并且不是剩余3个的情况
				if (0 == eachBlockNum % 3 && 1 != eachBlockNum / 3) {
					System.out.println("第" + i + "步:" + " 分成三份，每份" + (eachBlockNum / 3) + "个，"
							+ "称量其中两份，如果相等，则第三份是有假币，否则轻的那堆硬币有假币");
					eachBlockNum = eachBlockNum / 3;
				}
				// 如果能分出3份，则先分出三份，并且是剩余3个的情况
				else if (0 == eachBlockNum % 3 && 1 == eachBlockNum / 3) {
					System.out.println("第" + i + "步:" + " 分成三份，每份" + (eachBlockNum / 3) + "个，"
							+ "称量其中两份，如果相等，则第三份是有假币，否则轻的那堆硬币有假币");
					break;
				}
				// 如果能分出2份，则先分出2份，并且不是剩余2个的情况
				else if (0 == eachBlockNum % 2 && 1 != eachBlockNum / 2) {
					System.out.println("第" + i + "步:" + " 分成二份，每份" + (eachBlockNum / 2) + "个，" + "称量这两份，轻的是有假币的");
					eachBlockNum = eachBlockNum / 2;
				}
				// 如果能分出2份，则先分出2份，并且是剩余2个的情况
				else if (0 == eachBlockNum % 2 && 1 == eachBlockNum / 2) {
					System.out.println("第" + i + "步:" + " 分成二份，每份" + (eachBlockNum / 2) + "个，" + "称量这两个，轻的就是假币");
					break;
				}

			}else{//表示分不出两堆，只能分出三堆，其中一堆是一个
				eachBlockNum = eachBlockNum -1 ;
				if (eachBlockNum == 1) {
					System.out.println("已经能区分了");
					break;
				}
				
				// 如果能分出2份，则先分出2份，并且不是剩余2个的情况
				if (0 == eachBlockNum % 2 && 1 != eachBlockNum / 2) {
					System.out.println("第" + i + "步:" + " 分成三份，其中一份为一个，余下每份" + (eachBlockNum / 2) + "个，" + "称量这两份，轻的是有假币的");
					eachBlockNum = eachBlockNum / 2;
				}
				// 如果能分出2份，则先分出2份，并且是剩余2个的情况
				else if (0 == eachBlockNum % 2 && 1 == eachBlockNum / 2) {
					System.out.println("第" + i + "步:" + " 分成三份，其中一份为一个，余下每份" + (eachBlockNum / 2) + "个，" + "称量这两个，轻的就是假币");
					break;
				}

			}
			i++;
		}
	}

	public static void main(String[] args) {
		OneCoinCounterfeit occ = new OneCoinCounterfeit();
		occ.calculation();
	}

	/**
	 * 从一堆硬币中找出唯一的一个假冒的，需要多少步骤
	 */
}
