/**
 * Project: Assignment2
 * File: ServiceReader.java
 * Date: May 13, 2017
 * Time: 8:29:11 PM
 */

package a00904649.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.ApplicationException;
import a00904649.data.Motorcycle;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class ServiceReader {

	private static final Logger LOG = LogManager.getLogger();
	public static final String FIELD_DELIMITER = "\\|";
	public static final String FILE_NAME = "motorcycles.dat";
	public static final int MOTORCYCLES = 8;

	/**
	 * private constructor to prevent instantiation
	 */
	private ServiceReader() {
	}

	/**
	 * Read the Service input data from motorcycles.dat.
	 * 
	 * @return motorcycleList - List of motorcycles in service
	 * @throws ApplicationException
	 * @throws IOException
	 */
	public static List<Motorcycle> readMotorCyclesFile() throws ApplicationException {

		BufferedReader input = null;
		String[] motorcycles = new String[Motorcycle.MOTORCYCLES];
		List<Motorcycle> motorcycleList = new ArrayList<>();
		try {
			input = new BufferedReader(new FileReader(FILE_NAME));
			LOG.debug("Reading Service data from " + FILE_NAME);
			@SuppressWarnings("unused")
			// to store the first line of the unused data.
			String firstLine = input.readLine();

			while (input.ready()) {
				int i = 0;
				motorcycles[i] = input.readLine();
				Motorcycle motorcycle = readMotorcyclesString(motorcycles[i]);
				motorcycleList.add(motorcycle);
				i++;
			}
			LOG.debug("Service data were added to ArrayList");
			input.close();
		} catch (IOException e) {
			throw new ApplicationException(String.format("%s does not exist", FILE_NAME));
		}

		return motorcycleList;
	}

	/**
	 * Parse a motorcycle data string into a Motorcycle object;
	 * 
	 * @param row
	 *            String of Motorcycle object data.
	 * @return motorcycle
	 *         the Motorcycle object
	 * @throws ApplicationException
	 */

	private static Motorcycle readMotorcyclesString(String row) throws ApplicationException {

		String[] elements = row.split(FIELD_DELIMITER);
		if (elements.length != Motorcycle.ATTRIBUTE_COUNT) {
			throw new ApplicationException(
					String.format("Expected %d but got %d: %s", Motorcycle.ATTRIBUTE_COUNT, elements.length, Arrays.toString(elements)));
		}

		int index = 0;
		String id = elements[index++];
		String make = elements[index++];
		String model = elements[index++];
		int year = Integer.parseInt(elements[index++]);
		String serialNumber = elements[index++];
		int mileage = Integer.parseInt(elements[index++]);
		long customerID = Long.parseLong(elements[index++]);

		Motorcycle motorcycle = new Motorcycle(id, make, model, year, serialNumber, mileage, customerID);
		LOG.debug("Service data with model name " + motorcycle.getModel() + " created");
		return motorcycle;
	}
}
